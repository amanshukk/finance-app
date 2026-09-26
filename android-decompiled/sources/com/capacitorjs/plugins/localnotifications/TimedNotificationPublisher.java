package com.capacitorjs.plugins.localnotifications;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.getcapacitor.JSObject;
import com.getcapacitor.Logger;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes9.dex */
public class TimedNotificationPublisher extends BroadcastReceiver {
    public static String NOTIFICATION_KEY = "NotificationPublisher.notification";
    public static String CRON_KEY = "NotificationPublisher.cron";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Notification notification;
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 33) {
            notification = (Notification) intent.getParcelableExtra(NOTIFICATION_KEY, Notification.class);
        } else {
            notification = getParcelableExtraLegacy(intent, NOTIFICATION_KEY);
        }
        notification.when = System.currentTimeMillis();
        int id = intent.getIntExtra(LocalNotificationManager.NOTIFICATION_INTENT_KEY, Integer.MIN_VALUE);
        if (id == Integer.MIN_VALUE) {
            Logger.error(Logger.tags("LN"), "No valid id supplied", null);
        }
        NotificationStorage storage = new NotificationStorage(context);
        JSObject notificationJson = storage.getSavedNotificationAsJSObject(Integer.toString(id));
        LocalNotificationsPlugin.fireReceived(notificationJson);
        notificationManager.notify(id, notification);
        if (!rescheduleNotificationIfNeeded(context, intent, id)) {
            storage.deleteNotification(Integer.toString(id));
        }
    }

    private Notification getParcelableExtraLegacy(Intent intent, String string) {
        return (Notification) intent.getParcelableExtra(NOTIFICATION_KEY);
    }

    private boolean rescheduleNotificationIfNeeded(Context context, Intent intent, int id) {
        String dateString = intent.getStringExtra(CRON_KEY);
        if (dateString == null) {
            return false;
        }
        DateMatch date = DateMatch.fromMatchString(dateString);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        long trigger = date.nextTrigger(new Date());
        Intent clone = (Intent) intent.clone();
        int flags = Build.VERSION.SDK_INT >= 31 ? 268435456 | 33554432 : 268435456;
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, id, clone, flags);
        if (Build.VERSION.SDK_INT >= 31 && !alarmManager.canScheduleExactAlarms()) {
            Logger.warn("Capacitor/LocalNotification", "Exact alarms not allowed in user settings.  Notification scheduled with non-exact alarm.");
            alarmManager.set(1, trigger, pendingIntent);
        } else {
            alarmManager.setExact(1, trigger, pendingIntent);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Logger.debug(Logger.tags("LN"), "notification " + id + " will next fire at " + sdf.format(new Date(trigger)));
        return true;
    }
}
