package com.capacitorjs.plugins.localnotifications;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import com.getcapacitor.JSArray;
import com.getcapacitor.JSObject;
import com.getcapacitor.Logger;
import com.getcapacitor.PluginCall;
import java.util.List;
import org.json.JSONException;

/* loaded from: classes9.dex */
public class NotificationChannelManager {
    private Context context;
    private NotificationManager notificationManager;
    private static String CHANNEL_ID = "id";
    private static String CHANNEL_NAME = "name";
    private static String CHANNEL_DESCRIPTION = "description";
    private static String CHANNEL_IMPORTANCE = "importance";
    private static String CHANNEL_VISIBILITY = "visibility";
    private static String CHANNEL_SOUND = "sound";
    private static String CHANNEL_VIBRATE = "vibration";
    private static String CHANNEL_USE_LIGHTS = "lights";
    private static String CHANNEL_LIGHT_COLOR = "lightColor";

    public NotificationChannelManager(Context context) {
        this.context = context;
        this.notificationManager = (NotificationManager) context.getSystemService("notification");
    }

    public NotificationChannelManager(Context context, NotificationManager manager) {
        this.context = context;
        this.notificationManager = manager;
    }

    public void createChannel(PluginCall call) throws JSONException {
        if (Build.VERSION.SDK_INT >= 26) {
            JSObject channel = new JSObject();
            if (call.getString(CHANNEL_ID) != null) {
                channel.put(CHANNEL_ID, call.getString(CHANNEL_ID));
                if (call.getString(CHANNEL_NAME) != null) {
                    channel.put(CHANNEL_NAME, call.getString(CHANNEL_NAME));
                    channel.put(CHANNEL_IMPORTANCE, (Object) call.getInt(CHANNEL_IMPORTANCE, 3));
                    channel.put(CHANNEL_DESCRIPTION, call.getString(CHANNEL_DESCRIPTION, ""));
                    channel.put(CHANNEL_VISIBILITY, (Object) call.getInt(CHANNEL_VISIBILITY, 1));
                    channel.put(CHANNEL_SOUND, call.getString(CHANNEL_SOUND, null));
                    channel.put(CHANNEL_VIBRATE, (Object) call.getBoolean(CHANNEL_VIBRATE, false));
                    channel.put(CHANNEL_USE_LIGHTS, (Object) call.getBoolean(CHANNEL_USE_LIGHTS, false));
                    channel.put(CHANNEL_LIGHT_COLOR, call.getString(CHANNEL_LIGHT_COLOR, null));
                    createChannel(channel);
                    call.resolve();
                    return;
                }
                call.reject("Channel missing name");
                return;
            }
            call.reject("Channel missing identifier");
            return;
        }
        call.unavailable();
    }

    public void createChannel(JSObject channel) throws JSONException {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel(channel.getString(CHANNEL_ID), channel.getString(CHANNEL_NAME), channel.getInteger(CHANNEL_IMPORTANCE).intValue());
            notificationChannel.setDescription(channel.getString(CHANNEL_DESCRIPTION));
            notificationChannel.setLockscreenVisibility(channel.getInteger(CHANNEL_VISIBILITY).intValue());
            notificationChannel.enableVibration(channel.getBool(CHANNEL_VIBRATE).booleanValue());
            notificationChannel.enableLights(channel.getBool(CHANNEL_USE_LIGHTS).booleanValue());
            String lightColor = channel.getString(CHANNEL_LIGHT_COLOR);
            if (lightColor != null) {
                try {
                    notificationChannel.setLightColor(Color.parseColor(lightColor));
                } catch (IllegalArgumentException e) {
                    Logger.error(Logger.tags("NotificationChannel"), "Invalid color provided for light color.", null);
                }
            }
            String sound = channel.getString(CHANNEL_SOUND, null);
            if (sound != null && !sound.isEmpty()) {
                if (sound.contains(".")) {
                    sound = sound.substring(0, sound.lastIndexOf(46));
                }
                AudioAttributes audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
                Uri soundUri = Uri.parse("android.resource://" + this.context.getPackageName() + "/raw/" + sound);
                notificationChannel.setSound(soundUri, audioAttributes);
            }
            this.notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    public void deleteChannel(PluginCall call) {
        if (Build.VERSION.SDK_INT >= 26) {
            String channelId = call.getString("id");
            this.notificationManager.deleteNotificationChannel(channelId);
            call.resolve();
            return;
        }
        call.unavailable();
    }

    public void listChannels(PluginCall pluginCall) throws JSONException {
        if (Build.VERSION.SDK_INT >= 26) {
            List<NotificationChannel> notificationChannels = this.notificationManager.getNotificationChannels();
            JSArray channels = new JSArray();
            for (NotificationChannel notificationChannel : notificationChannels) {
                JSObject channel = new JSObject();
                channel.put(CHANNEL_ID, notificationChannel.getId());
                channel.put(CHANNEL_NAME, (Object) notificationChannel.getName());
                channel.put(CHANNEL_DESCRIPTION, notificationChannel.getDescription());
                channel.put(CHANNEL_IMPORTANCE, notificationChannel.getImportance());
                channel.put(CHANNEL_VISIBILITY, notificationChannel.getLockscreenVisibility());
                channel.put(CHANNEL_SOUND, (Object) notificationChannel.getSound());
                channel.put(CHANNEL_VIBRATE, notificationChannel.shouldVibrate());
                channel.put(CHANNEL_USE_LIGHTS, notificationChannel.shouldShowLights());
                channel.put(CHANNEL_LIGHT_COLOR, String.format("#%06X", Integer.valueOf(16777215 & notificationChannel.getLightColor())));
                Logger.debug(Logger.tags("NotificationChannel"), "visibility " + notificationChannel.getLockscreenVisibility());
                Logger.debug(Logger.tags("NotificationChannel"), "importance " + notificationChannel.getImportance());
                channels.put(channel);
            }
            JSObject result = new JSObject();
            result.put("channels", (Object) channels);
            pluginCall.resolve(result);
            return;
        }
        pluginCall.unavailable();
    }
}
