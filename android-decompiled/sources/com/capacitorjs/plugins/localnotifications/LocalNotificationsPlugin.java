package com.capacitorjs.plugins.localnotifications;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import androidx.activity.result.ActivityResult;
import androidx.core.app.NotificationCompat;
import com.getcapacitor.Bridge;
import com.getcapacitor.JSArray;
import com.getcapacitor.JSObject;
import com.getcapacitor.PermissionState;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginHandle;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.ActivityCallback;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.getcapacitor.annotation.Permission;
import com.getcapacitor.annotation.PermissionCallback;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@CapacitorPlugin(name = "LocalNotifications", permissions = {@Permission(alias = LocalNotificationsPlugin.LOCAL_NOTIFICATIONS, strings = {"android.permission.POST_NOTIFICATIONS"})})
/* loaded from: classes9.dex */
public class LocalNotificationsPlugin extends Plugin {
    static final String LOCAL_NOTIFICATIONS = "display";
    private static Bridge staticBridge = null;
    private LocalNotificationManager manager;
    private NotificationChannelManager notificationChannelManager;
    public NotificationManager notificationManager;
    private NotificationStorage notificationStorage;

    @Override // com.getcapacitor.Plugin
    public void load() {
        super.load();
        this.notificationStorage = new NotificationStorage(getContext());
        this.manager = new LocalNotificationManager(this.notificationStorage, getActivity(), getContext(), this.bridge.getConfig());
        this.manager.createNotificationChannel();
        this.notificationChannelManager = new NotificationChannelManager(getActivity());
        this.notificationManager = (NotificationManager) getActivity().getSystemService("notification");
        staticBridge = this.bridge;
    }

    @Override // com.getcapacitor.Plugin
    protected void handleOnNewIntent(Intent data) {
        JSObject dataJson;
        super.handleOnNewIntent(data);
        if ("android.intent.action.MAIN".equals(data.getAction()) && (dataJson = this.manager.handleNotificationActionPerformed(data, this.notificationStorage)) != null) {
            notifyListeners("localNotificationActionPerformed", dataJson, true);
        }
    }

    @PluginMethod
    public void schedule(PluginCall call) throws JSONException {
        JSONArray ids;
        List<LocalNotification> localNotifications = LocalNotification.buildNotificationList(call);
        if (localNotifications != null && (ids = this.manager.schedule(call, localNotifications)) != null) {
            this.notificationStorage.appendNotifications(localNotifications);
            JSObject result = new JSObject();
            JSArray jsArray = new JSArray();
            for (int i = 0; i < ids.length(); i++) {
                try {
                    JSObject notification = new JSObject().put("id", ids.getInt(i));
                    jsArray.put(notification);
                } catch (Exception e) {
                }
            }
            result.put("notifications", (Object) jsArray);
            call.resolve(result);
        }
    }

    @PluginMethod
    public void cancel(PluginCall call) throws JSONException {
        this.manager.cancel(call);
    }

    @PluginMethod
    public void getPending(PluginCall call) throws JSONException {
        List<LocalNotification> notifications = this.notificationStorage.getSavedNotifications();
        JSObject result = LocalNotification.buildLocalNotificationPendingList(notifications);
        call.resolve(result);
    }

    @PluginMethod
    public void registerActionTypes(PluginCall call) {
        JSArray types = call.getArray("types");
        Map<String, NotificationAction[]> typesArray = NotificationAction.buildTypes(types);
        this.notificationStorage.writeActionGroup(typesArray);
        call.resolve();
    }

    @PluginMethod
    public void areEnabled(PluginCall call) throws JSONException {
        JSObject data = new JSObject();
        data.put("value", this.manager.areNotificationsEnabled());
        call.resolve(data);
    }

    @PluginMethod
    public void getDeliveredNotifications(PluginCall pluginCall) throws JSONException {
        JSArray jSArray = new JSArray();
        StatusBarNotification[] activeNotifications = this.notificationManager.getActiveNotifications();
        for (StatusBarNotification notif : activeNotifications) {
            JSObject jsNotif = new JSObject();
            jsNotif.put("id", notif.getId());
            jsNotif.put("tag", notif.getTag());
            Notification notification = notif.getNotification();
            if (notification != null) {
                jsNotif.put("title", notification.extras.getCharSequence(NotificationCompat.EXTRA_TITLE));
                jsNotif.put("body", notification.extras.getCharSequence(NotificationCompat.EXTRA_TEXT));
                jsNotif.put("group", notification.getGroup());
                jsNotif.put("groupSummary", (notification.flags & 512) != 0);
                JSObject extras = new JSObject();
                for (String key : notification.extras.keySet()) {
                    extras.put(key, notification.extras.get(key));
                }
                jsNotif.put("data", (Object) extras);
            }
            jSArray.put(jsNotif);
        }
        JSObject jSObject = new JSObject();
        jSObject.put("notifications", (Object) jSArray);
        pluginCall.resolve(jSObject);
    }

    @PluginMethod
    public void removeDeliveredNotifications(PluginCall call) {
        JSArray notifications = call.getArray("notifications");
        try {
            for (Object o : notifications.toList()) {
                if (o instanceof JSONObject) {
                    JSObject notif = JSObject.fromJSONObject((JSONObject) o);
                    String tag = notif.getString("tag");
                    Integer id = notif.getInteger("id");
                    if (tag == null) {
                        this.notificationManager.cancel(id.intValue());
                    } else {
                        this.notificationManager.cancel(tag, id.intValue());
                    }
                } else {
                    call.reject("Expected notifications to be a list of notification objects");
                }
            }
        } catch (JSONException e) {
            call.reject(e.getMessage());
        }
        call.resolve();
    }

    @PluginMethod
    public void removeAllDeliveredNotifications(PluginCall call) {
        this.notificationManager.cancelAll();
        call.resolve();
    }

    @PluginMethod
    public void createChannel(PluginCall call) throws JSONException {
        this.notificationChannelManager.createChannel(call);
    }

    @PluginMethod
    public void deleteChannel(PluginCall call) {
        this.notificationChannelManager.deleteChannel(call);
    }

    @PluginMethod
    public void listChannels(PluginCall call) throws JSONException {
        this.notificationChannelManager.listChannels(call);
    }

    @Override // com.getcapacitor.Plugin
    @PluginMethod
    public void checkPermissions(PluginCall call) throws JSONException {
        if (Build.VERSION.SDK_INT < 33) {
            JSObject permissionsResultJSON = new JSObject();
            permissionsResultJSON.put(LOCAL_NOTIFICATIONS, getNotificationPermissionText());
            call.resolve(permissionsResultJSON);
            return;
        }
        super.checkPermissions(call);
    }

    @Override // com.getcapacitor.Plugin
    @PluginMethod
    public void requestPermissions(PluginCall call) throws JSONException {
        if (Build.VERSION.SDK_INT < 33 || getPermissionState(LOCAL_NOTIFICATIONS) == PermissionState.GRANTED) {
            JSObject permissionsResultJSON = new JSObject();
            permissionsResultJSON.put(LOCAL_NOTIFICATIONS, getNotificationPermissionText());
            call.resolve(permissionsResultJSON);
            return;
        }
        requestPermissionForAlias(LOCAL_NOTIFICATIONS, call, "permissionsCallback");
    }

    @PluginMethod
    public void changeExactNotificationSetting(PluginCall call) throws JSONException {
        if (Build.VERSION.SDK_INT >= 31) {
            startActivityForResult(call, new Intent("android.settings.REQUEST_SCHEDULE_EXACT_ALARM", Uri.parse("package:" + getActivity().getPackageName())), "alarmPermissionsCallback");
        } else {
            checkExactNotificationSetting(call);
        }
    }

    @PluginMethod
    public void checkExactNotificationSetting(PluginCall call) throws JSONException {
        JSObject permissionsResultJSON = new JSObject();
        permissionsResultJSON.put("exact_alarm", getExactAlarmPermissionText());
        call.resolve(permissionsResultJSON);
    }

    @PermissionCallback
    private void permissionsCallback(PluginCall call) throws JSONException {
        JSObject permissionsResultJSON = new JSObject();
        permissionsResultJSON.put(LOCAL_NOTIFICATIONS, getNotificationPermissionText());
        call.resolve(permissionsResultJSON);
    }

    @ActivityCallback
    private void alarmPermissionsCallback(PluginCall call, ActivityResult result) throws JSONException {
        checkExactNotificationSetting(call);
    }

    private String getNotificationPermissionText() {
        if (this.manager.areNotificationsEnabled()) {
            return "granted";
        }
        return "denied";
    }

    private String getExactAlarmPermissionText() {
        if (Build.VERSION.SDK_INT < 31) {
            return "granted";
        }
        AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(NotificationCompat.CATEGORY_ALARM);
        return alarmManager.canScheduleExactAlarms() ? "granted" : "denied";
    }

    public static void fireReceived(JSObject notification) {
        LocalNotificationsPlugin localNotificationsPlugin = getLocalNotificationsInstance();
        if (localNotificationsPlugin != null) {
            localNotificationsPlugin.notifyListeners("localNotificationReceived", notification, true);
        }
    }

    public static LocalNotificationsPlugin getLocalNotificationsInstance() {
        PluginHandle handle;
        if (staticBridge == null || staticBridge.getWebView() == null || (handle = staticBridge.getPlugin("LocalNotifications")) == null) {
            return null;
        }
        return (LocalNotificationsPlugin) handle.getInstance();
    }
}
