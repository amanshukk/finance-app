package com.capacitorjs.plugins.localnotifications;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.UserManager;
import com.getcapacitor.CapConfig;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONException;

/* loaded from: classes9.dex */
public class LocalNotificationRestoreReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) throws JSONException {
        Date at;
        UserManager um = (UserManager) context.getSystemService(UserManager.class);
        if (um != null && um.isUserUnlocked()) {
            NotificationStorage storage = new NotificationStorage(context);
            List<String> ids = storage.getSavedNotificationIds();
            ArrayList<LocalNotification> notifications = new ArrayList<>(ids.size());
            ArrayList<LocalNotification> updatedNotifications = new ArrayList<>();
            for (String id : ids) {
                LocalNotification notification = storage.getSavedNotification(id);
                if (notification != null) {
                    LocalNotificationSchedule schedule = notification.getSchedule();
                    if (schedule != null && (at = schedule.getAt()) != null && at.before(new Date())) {
                        long newDateTime = new Date().getTime() + 15000;
                        schedule.setAt(new Date(newDateTime));
                        notification.setSchedule(schedule);
                        updatedNotifications.add(notification);
                    }
                    notifications.add(notification);
                }
            }
            if (updatedNotifications.size() > 0) {
                storage.appendNotifications(updatedNotifications);
            }
            CapConfig config = CapConfig.loadDefault(context);
            LocalNotificationManager localNotificationManager = new LocalNotificationManager(storage, null, context, config);
            localNotificationManager.schedule(null, notifications);
        }
    }
}
