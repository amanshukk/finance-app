package com.capacitorjs.plugins.localnotifications;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.RemoteInput;
import androidx.webkit.Profile;
import com.getcapacitor.CapConfig;
import com.getcapacitor.JSObject;
import com.getcapacitor.Logger;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginConfig;
import com.getcapacitor.plugin.util.AssetUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes9.dex */
public class LocalNotificationManager {
    public static final String ACTION_INTENT_KEY = "LocalNotificationUserAction";
    public static final String DEFAULT_NOTIFICATION_CHANNEL_ID = "default";
    private static final String DEFAULT_PRESS_ACTION = "tap";
    public static final String NOTIFICATION_INTENT_KEY = "LocalNotificationId";
    public static final String NOTIFICATION_IS_REMOVABLE_KEY = "LocalNotificationRepeating";
    public static final String NOTIFICATION_OBJ_INTENT_KEY = "LocalNotficationObject";
    public static final String REMOTE_INPUT_KEY = "LocalNotificationRemoteInput";
    private Activity activity;
    private PluginConfig config;
    private Context context;
    private NotificationStorage storage;
    private static int defaultSoundID = 0;
    private static int defaultSmallIconID = 0;

    public LocalNotificationManager(NotificationStorage notificationStorage, Activity activity, Context context, CapConfig config) {
        this.storage = notificationStorage;
        this.activity = activity;
        this.context = context;
        this.config = config.getPluginConfiguration("LocalNotifications");
    }

    public JSObject handleNotificationActionPerformed(Intent data, NotificationStorage notificationStorage) throws JSONException {
        Logger.debug(Logger.tags("LN"), "LocalNotification received: " + data.getDataString());
        int notificationId = data.getIntExtra(NOTIFICATION_INTENT_KEY, Integer.MIN_VALUE);
        if (notificationId != Integer.MIN_VALUE) {
            boolean isRemovable = data.getBooleanExtra(NOTIFICATION_IS_REMOVABLE_KEY, true);
            if (isRemovable) {
                notificationStorage.deleteNotification(Integer.toString(notificationId));
            }
            JSObject dataJson = new JSObject();
            Bundle results = RemoteInput.getResultsFromIntent(data);
            if (results != null) {
                CharSequence input = results.getCharSequence(REMOTE_INPUT_KEY);
                dataJson.put("inputValue", input.toString());
            }
            String menuAction = data.getStringExtra(ACTION_INTENT_KEY);
            dismissVisibleNotification(notificationId);
            dataJson.put("actionId", menuAction);
            JSONObject request = null;
            try {
                String notificationJsonString = data.getStringExtra(NOTIFICATION_OBJ_INTENT_KEY);
                if (notificationJsonString != null) {
                    request = new JSObject(notificationJsonString);
                }
            } catch (JSONException e) {
            }
            dataJson.put("notification", (Object) request);
            return dataJson;
        }
        Logger.debug(Logger.tags("LN"), "Activity started without notification attached");
        return null;
    }

    public void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel channel = new NotificationChannel(DEFAULT_NOTIFICATION_CHANNEL_ID, Profile.DEFAULT_PROFILE_NAME, 3);
            channel.setDescription(Profile.DEFAULT_PROFILE_NAME);
            AudioAttributes audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(4).build();
            Uri soundUri = getDefaultSoundUrl(this.context);
            if (soundUri != null) {
                channel.setSound(soundUri, audioAttributes);
            }
            NotificationManager notificationManager = (NotificationManager) this.context.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    public JSONArray schedule(PluginCall call, List<LocalNotification> localNotifications) {
        JSONArray ids = new JSONArray();
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this.context);
        boolean notificationsEnabled = notificationManager.areNotificationsEnabled();
        if (!notificationsEnabled) {
            if (call != null) {
                call.reject("Notifications not enabled on this device");
            }
            return null;
        }
        for (LocalNotification localNotification : localNotifications) {
            Integer id = localNotification.getId();
            if (localNotification.getId() == null) {
                if (call != null) {
                    call.reject("LocalNotification missing identifier");
                }
                return null;
            }
            dismissVisibleNotification(id.intValue());
            cancelTimerForNotification(id);
            buildNotification(notificationManager, localNotification, call);
            ids.put(id);
        }
        return ids;
    }

    private void buildNotification(NotificationManagerCompat notificationManager, LocalNotification localNotification, PluginCall call) {
        String channelId = DEFAULT_NOTIFICATION_CHANNEL_ID;
        if (localNotification.getChannelId() != null) {
            channelId = localNotification.getChannelId();
        }
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this.context, channelId).setContentTitle(localNotification.getTitle()).setContentText(localNotification.getBody()).setAutoCancel(localNotification.isAutoCancel()).setOngoing(localNotification.isOngoing()).setPriority(0).setGroupSummary(localNotification.isGroupSummary());
        if (localNotification.getLargeBody() != null) {
            mBuilder.setStyle(new NotificationCompat.BigTextStyle().bigText(localNotification.getLargeBody()).setSummaryText(localNotification.getSummaryText()));
        }
        if (localNotification.getInboxList() != null) {
            NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
            for (String line : localNotification.getInboxList()) {
                inboxStyle.addLine(line);
            }
            inboxStyle.setBigContentTitle(localNotification.getTitle());
            inboxStyle.setSummaryText(localNotification.getSummaryText());
            mBuilder.setStyle(inboxStyle);
        }
        String sound = localNotification.getSound(this.context, getDefaultSound(this.context));
        if (sound != null) {
            Uri soundUri = Uri.parse(sound);
            this.context.grantUriPermission("com.android.systemui", soundUri, 1);
            mBuilder.setSound(soundUri);
            mBuilder.setDefaults(6);
        } else {
            mBuilder.setDefaults(-1);
        }
        String group = localNotification.getGroup();
        if (group != null) {
            mBuilder.setGroup(group);
            if (localNotification.isGroupSummary()) {
                mBuilder.setSubText(localNotification.getSummaryText());
            }
        }
        mBuilder.setVisibility(0);
        mBuilder.setOnlyAlertOnce(true);
        mBuilder.setSmallIcon(localNotification.getSmallIcon(this.context, getDefaultSmallIcon(this.context)));
        mBuilder.setLargeIcon(localNotification.getLargeIcon(this.context));
        String iconColor = localNotification.getIconColor(this.config.getString("iconColor"));
        if (iconColor != null) {
            try {
                mBuilder.setColor(Color.parseColor(iconColor));
            } catch (IllegalArgumentException e) {
                if (call != null) {
                    call.reject("Invalid color provided. Must be a hex string (ex: #ff0000");
                    return;
                }
                return;
            }
        }
        createActionIntents(localNotification, mBuilder);
        Notification buildNotification = mBuilder.build();
        if (localNotification.isScheduled()) {
            triggerScheduledNotification(buildNotification, localNotification);
            return;
        }
        try {
            JSObject notificationJson = new JSObject(localNotification.getSource());
            LocalNotificationsPlugin.fireReceived(notificationJson);
        } catch (JSONException e2) {
        }
        notificationManager.notify(localNotification.getId().intValue(), buildNotification);
    }

    private void createActionIntents(LocalNotification localNotification, NotificationCompat.Builder mBuilder) {
        Intent intent = buildIntent(localNotification, DEFAULT_PRESS_ACTION);
        int flags = Build.VERSION.SDK_INT >= 31 ? 268435456 | 33554432 : 268435456;
        PendingIntent pendingIntent = PendingIntent.getActivity(this.context, localNotification.getId().intValue(), intent, flags);
        mBuilder.setContentIntent(pendingIntent);
        String actionTypeId = localNotification.getActionTypeId();
        if (actionTypeId != null) {
            NotificationAction[] actionGroup = this.storage.getActionGroup(actionTypeId);
            for (NotificationAction notificationAction : actionGroup) {
                Intent actionIntent = buildIntent(localNotification, notificationAction.getId());
                PendingIntent actionPendingIntent = PendingIntent.getActivity(this.context, localNotification.getId().intValue() + notificationAction.getId().hashCode(), actionIntent, flags);
                NotificationCompat.Action.Builder actionBuilder = new NotificationCompat.Action.Builder(R.drawable.ic_transparent, notificationAction.getTitle(), actionPendingIntent);
                if (notificationAction.isInput()) {
                    RemoteInput remoteInput = new RemoteInput.Builder(REMOTE_INPUT_KEY).setLabel(notificationAction.getTitle()).build();
                    actionBuilder.addRemoteInput(remoteInput);
                }
                mBuilder.addAction(actionBuilder.build());
            }
        }
        Intent dissmissIntent = new Intent(this.context, (Class<?>) NotificationDismissReceiver.class);
        dissmissIntent.setFlags(268468224);
        dissmissIntent.putExtra(NOTIFICATION_INTENT_KEY, localNotification.getId());
        dissmissIntent.putExtra(ACTION_INTENT_KEY, "dismiss");
        LocalNotificationSchedule schedule = localNotification.getSchedule();
        dissmissIntent.putExtra(NOTIFICATION_IS_REMOVABLE_KEY, schedule == null || schedule.isRemovable());
        int flags2 = 0;
        if (Build.VERSION.SDK_INT >= 31) {
            flags2 = 33554432;
        }
        PendingIntent deleteIntent = PendingIntent.getBroadcast(this.context, localNotification.getId().intValue(), dissmissIntent, flags2);
        mBuilder.setDeleteIntent(deleteIntent);
    }

    private Intent buildIntent(LocalNotification localNotification, String action) {
        Intent intent;
        if (this.activity != null) {
            intent = new Intent(this.context, this.activity.getClass());
        } else {
            String packageName = this.context.getPackageName();
            intent = this.context.getPackageManager().getLaunchIntentForPackage(packageName);
        }
        intent.setAction("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setFlags(603979776);
        intent.putExtra(NOTIFICATION_INTENT_KEY, localNotification.getId());
        intent.putExtra(ACTION_INTENT_KEY, action);
        intent.putExtra(NOTIFICATION_OBJ_INTENT_KEY, localNotification.getSource());
        LocalNotificationSchedule schedule = localNotification.getSchedule();
        intent.putExtra(NOTIFICATION_IS_REMOVABLE_KEY, schedule == null || schedule.isRemovable());
        return intent;
    }

    private void triggerScheduledNotification(Notification notification, LocalNotification request) {
        int flags;
        AlarmManager alarmManager = (AlarmManager) this.context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        LocalNotificationSchedule schedule = request.getSchedule();
        Intent notificationIntent = new Intent(this.context, (Class<?>) TimedNotificationPublisher.class);
        notificationIntent.putExtra(NOTIFICATION_INTENT_KEY, request.getId());
        notificationIntent.putExtra(TimedNotificationPublisher.NOTIFICATION_KEY, notification);
        if (Build.VERSION.SDK_INT >= 31) {
            int flags2 = 268435456 | 33554432;
            flags = flags2;
        } else {
            flags = 268435456;
        }
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.context, request.getId().intValue(), notificationIntent, flags);
        Date at = schedule.getAt();
        if (at != null) {
            if (at.getTime() < new Date().getTime()) {
                Logger.error(Logger.tags("LN"), "Scheduled time must be *after* current time", null);
                return;
            } else if (!schedule.isRepeating()) {
                setExactIfPossible(alarmManager, schedule, at.getTime(), pendingIntent);
                return;
            } else {
                long interval = at.getTime() - new Date().getTime();
                alarmManager.setRepeating(1, at.getTime(), interval, pendingIntent);
                return;
            }
        }
        String every = schedule.getEvery();
        if (every != null) {
            Long everyInterval = schedule.getEveryInterval();
            if (everyInterval != null) {
                long startTime = everyInterval.longValue() + new Date().getTime();
                alarmManager.setRepeating(1, startTime, everyInterval.longValue(), pendingIntent);
                return;
            }
            return;
        }
        DateMatch on = schedule.getOn();
        if (on != null) {
            long trigger = on.nextTrigger(new Date());
            notificationIntent.putExtra(TimedNotificationPublisher.CRON_KEY, on.toMatchString());
            setExactIfPossible(alarmManager, schedule, trigger, PendingIntent.getBroadcast(this.context, request.getId().intValue(), notificationIntent, flags));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Logger.debug(Logger.tags("LN"), "notification " + request.getId() + " will next fire at " + sdf.format(new Date(trigger)));
        }
    }

    private void setExactIfPossible(AlarmManager alarmManager, LocalNotificationSchedule schedule, long trigger, PendingIntent pendingIntent) {
        if (Build.VERSION.SDK_INT >= 31 && !alarmManager.canScheduleExactAlarms()) {
            Logger.warn("Capacitor/LocalNotification", "Exact alarms not allowed in user settings.  Notification scheduled with non-exact alarm.");
            if (schedule.allowWhileIdle()) {
                alarmManager.setAndAllowWhileIdle(0, trigger, pendingIntent);
                return;
            } else {
                alarmManager.set(1, trigger, pendingIntent);
                return;
            }
        }
        if (schedule.allowWhileIdle()) {
            alarmManager.setExactAndAllowWhileIdle(0, trigger, pendingIntent);
        } else {
            alarmManager.setExact(1, trigger, pendingIntent);
        }
    }

    public void cancel(PluginCall call) throws JSONException {
        List<Integer> notificationsToCancel = LocalNotification.getLocalNotificationPendingList(call);
        if (notificationsToCancel != null) {
            for (Integer id : notificationsToCancel) {
                dismissVisibleNotification(id.intValue());
                cancelTimerForNotification(id);
                this.storage.deleteNotification(Integer.toString(id.intValue()));
            }
        }
        call.resolve();
    }

    private void cancelTimerForNotification(Integer notificationId) {
        Intent intent = new Intent(this.context, (Class<?>) TimedNotificationPublisher.class);
        int flags = 0;
        if (Build.VERSION.SDK_INT >= 31) {
            flags = 33554432;
        }
        PendingIntent pi = PendingIntent.getBroadcast(this.context, notificationId.intValue(), intent, flags);
        if (pi != null) {
            AlarmManager alarmManager = (AlarmManager) this.context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            alarmManager.cancel(pi);
        }
    }

    private void dismissVisibleNotification(int notificationId) {
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this.context);
        notificationManager.cancel(notificationId);
    }

    public boolean areNotificationsEnabled() {
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this.context);
        return notificationManager.areNotificationsEnabled();
    }

    public Uri getDefaultSoundUrl(Context context) {
        int soundId = getDefaultSound(context);
        if (soundId != 0) {
            return Uri.parse("android.resource://" + context.getPackageName() + "/" + soundId);
        }
        return null;
    }

    private int getDefaultSound(Context context) {
        if (defaultSoundID != 0) {
            return defaultSoundID;
        }
        int resId = 0;
        String soundConfigResourceName = AssetUtil.getResourceBaseName(this.config.getString("sound"));
        if (soundConfigResourceName != null) {
            resId = AssetUtil.getResourceID(context, soundConfigResourceName, "raw");
        }
        defaultSoundID = resId;
        return resId;
    }

    private int getDefaultSmallIcon(Context context) {
        if (defaultSmallIconID != 0) {
            return defaultSmallIconID;
        }
        int resId = 0;
        String smallIconConfigResourceName = AssetUtil.getResourceBaseName(this.config.getString("smallIcon"));
        if (smallIconConfigResourceName != null) {
            resId = AssetUtil.getResourceID(context, smallIconConfigResourceName, "drawable");
        }
        if (resId == 0) {
            resId = android.R.drawable.ic_dialog_info;
        }
        defaultSmallIconID = resId;
        return resId;
    }
}
