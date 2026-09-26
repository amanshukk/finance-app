package com.capacitorjs.plugins.localnotifications;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.getcapacitor.Logger;

/* loaded from: classes9.dex */
public class NotificationDismissReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        int intExtra = intent.getIntExtra(LocalNotificationManager.NOTIFICATION_INTENT_KEY, Integer.MIN_VALUE);
        if (intExtra != Integer.MIN_VALUE) {
            boolean isRemovable = intent.getBooleanExtra(LocalNotificationManager.NOTIFICATION_IS_REMOVABLE_KEY, true);
            if (isRemovable) {
                NotificationStorage notificationStorage = new NotificationStorage(context);
                notificationStorage.deleteNotification(Integer.toString(intExtra));
                return;
            }
            return;
        }
        Logger.error(Logger.tags("LN"), "Invalid notification dismiss operation", null);
    }
}
