package com.capacitorjs.plugins.localnotifications;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.getcapacitor.JSArray;
import com.getcapacitor.JSObject;
import com.getcapacitor.Logger;
import com.getcapacitor.PluginCall;
import com.getcapacitor.plugin.util.AssetUtil;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import kotlinx.coroutines.DebugKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes9.dex */
public class LocalNotification {
    private String actionTypeId;
    private List<LocalNotificationAttachment> attachments;
    private boolean autoCancel;
    private String body;
    private String channelId;
    private JSObject extra;
    private String group;
    private boolean groupSummary;
    private String iconColor;
    private Integer id;
    private List<String> inboxList;
    private String largeBody;
    private String largeIcon;
    private boolean ongoing;
    private LocalNotificationSchedule schedule;
    private String smallIcon;
    private String sound;
    private String source;
    private String summaryText;
    private String title;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setLargeBody(String largeBody) {
        this.largeBody = largeBody;
    }

    public String getLargeBody() {
        return this.largeBody;
    }

    public void setSummaryText(String summaryText) {
        this.summaryText = summaryText;
    }

    public String getSummaryText() {
        return this.summaryText;
    }

    public LocalNotificationSchedule getSchedule() {
        return this.schedule;
    }

    public void setSchedule(LocalNotificationSchedule schedule) {
        this.schedule = schedule;
    }

    public String getSound(Context context, int defaultSound) {
        int resId = 0;
        String name = AssetUtil.getResourceBaseName(this.sound);
        if (name != null) {
            resId = AssetUtil.getResourceID(context, name, "raw");
        }
        if (resId == 0) {
            resId = defaultSound;
        }
        if (resId == 0) {
            return null;
        }
        String soundPath = "android.resource://" + context.getPackageName() + "/" + resId;
        return soundPath;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public void setSmallIcon(String smallIcon) {
        this.smallIcon = AssetUtil.getResourceBaseName(smallIcon);
    }

    public void setLargeIcon(String largeIcon) {
        this.largeIcon = AssetUtil.getResourceBaseName(largeIcon);
    }

    public void setInboxList(List<String> inboxList) {
        this.inboxList = inboxList;
    }

    public List<String> getInboxList() {
        return this.inboxList;
    }

    public String getIconColor(String globalColor) {
        if (this.iconColor != null) {
            return this.iconColor;
        }
        return globalColor;
    }

    public void setIconColor(String iconColor) {
        this.iconColor = iconColor;
    }

    public List<LocalNotificationAttachment> getAttachments() {
        return this.attachments;
    }

    public void setAttachments(List<LocalNotificationAttachment> attachments) {
        this.attachments = attachments;
    }

    public String getActionTypeId() {
        return this.actionTypeId;
    }

    public void setActionTypeId(String actionTypeId) {
        this.actionTypeId = actionTypeId;
    }

    public String getGroup() {
        return this.group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public JSObject getExtra() {
        return this.extra;
    }

    public void setExtra(JSObject extra) {
        this.extra = extra;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isGroupSummary() {
        return this.groupSummary;
    }

    public void setGroupSummary(boolean groupSummary) {
        this.groupSummary = groupSummary;
    }

    public boolean isOngoing() {
        return this.ongoing;
    }

    public void setOngoing(boolean ongoing) {
        this.ongoing = ongoing;
    }

    public boolean isAutoCancel() {
        return this.autoCancel;
    }

    public void setAutoCancel(boolean autoCancel) {
        this.autoCancel = autoCancel;
    }

    public String getChannelId() {
        return this.channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public static List<LocalNotification> buildNotificationList(PluginCall call) throws JSONException {
        JSArray notificationArray = call.getArray("notifications");
        if (notificationArray == null) {
            call.reject("Must provide notifications array as notifications option");
            return null;
        }
        List<LocalNotification> resultLocalNotifications = new ArrayList<>(notificationArray.length());
        try {
            List<JSONObject> notificationsJson = notificationArray.toList();
            for (JSONObject jsonNotification : notificationsJson) {
                try {
                    long identifier = jsonNotification.getLong("id");
                    if (identifier <= 2147483647L && identifier >= -2147483648L) {
                        JSObject notification = JSObject.fromJSONObject(jsonNotification);
                        try {
                            LocalNotification activeLocalNotification = buildNotificationFromJSObject(notification);
                            resultLocalNotifications.add(activeLocalNotification);
                        } catch (ParseException e) {
                            call.reject("Invalid date format sent to Notification plugin", e);
                            return null;
                        }
                    }
                    call.reject("The identifier should be a Java int");
                    return null;
                } catch (JSONException e2) {
                    call.reject("Invalid JSON object sent to NotificationPlugin", e2);
                    return null;
                }
            }
            return resultLocalNotifications;
        } catch (JSONException e3) {
            call.reject("Provided notification format is invalid");
            return null;
        }
    }

    public static LocalNotification buildNotificationFromJSObject(JSObject jsonObject) throws ParseException {
        LocalNotification localNotification = new LocalNotification();
        localNotification.setSource(jsonObject.toString());
        localNotification.setId(jsonObject.getInteger("id"));
        localNotification.setBody(jsonObject.getString("body"));
        localNotification.setLargeBody(jsonObject.getString("largeBody"));
        localNotification.setSummaryText(jsonObject.getString("summaryText"));
        localNotification.setActionTypeId(jsonObject.getString("actionTypeId"));
        localNotification.setGroup(jsonObject.getString("group"));
        localNotification.setSound(jsonObject.getString("sound"));
        localNotification.setTitle(jsonObject.getString("title"));
        localNotification.setSmallIcon(jsonObject.getString("smallIcon"));
        localNotification.setLargeIcon(jsonObject.getString("largeIcon"));
        localNotification.setIconColor(jsonObject.getString("iconColor"));
        localNotification.setAttachments(LocalNotificationAttachment.getAttachments(jsonObject));
        localNotification.setGroupSummary(jsonObject.getBoolean("groupSummary", false).booleanValue());
        localNotification.setChannelId(jsonObject.getString("channelId"));
        JSObject schedule = jsonObject.getJSObject("schedule");
        if (schedule != null) {
            localNotification.setSchedule(new LocalNotificationSchedule(schedule));
        }
        localNotification.setExtra(jsonObject.getJSObject("extra"));
        localNotification.setOngoing(jsonObject.getBoolean("ongoing", false).booleanValue());
        localNotification.setAutoCancel(jsonObject.getBoolean("autoCancel", true).booleanValue());
        try {
            JSONArray inboxList = jsonObject.getJSONArray("inboxList");
            if (inboxList != null) {
                List<String> inboxStringList = new ArrayList<>();
                for (int i = 0; i < inboxList.length(); i++) {
                    inboxStringList.add(inboxList.getString(i));
                }
                localNotification.setInboxList(inboxStringList);
            }
        } catch (Exception e) {
        }
        return localNotification;
    }

    public static List<Integer> getLocalNotificationPendingList(PluginCall call) throws JSONException {
        List<JSONObject> notifications = null;
        try {
            notifications = call.getArray("notifications").toList();
        } catch (JSONException e) {
        }
        if (notifications == null || notifications.size() == 0) {
            call.reject("Must provide notifications array as notifications option");
            return null;
        }
        List<Integer> notificationsList = new ArrayList<>(notifications.size());
        for (JSONObject notificationToCancel : notifications) {
            try {
                notificationsList.add(Integer.valueOf(notificationToCancel.getInt("id")));
            } catch (JSONException e2) {
            }
        }
        return notificationsList;
    }

    public static JSObject buildLocalNotificationPendingList(List<LocalNotification> notifications) throws JSONException {
        JSObject jSObject = new JSObject();
        JSArray jSArray = new JSArray();
        for (LocalNotification notification : notifications) {
            JSObject jsNotification = new JSObject();
            jsNotification.put("id", notification.getId());
            jsNotification.put("title", notification.getTitle());
            jsNotification.put("body", notification.getBody());
            LocalNotificationSchedule schedule = notification.getSchedule();
            if (schedule != null) {
                JSObject jsSchedule = new JSObject();
                jsSchedule.put("at", (Object) schedule.getAt());
                jsSchedule.put("every", schedule.getEvery());
                jsSchedule.put("count", schedule.getCount());
                jsSchedule.put(DebugKt.DEBUG_PROPERTY_VALUE_ON, (Object) schedule.getOnObj());
                jsSchedule.put("repeats", schedule.isRepeating());
                jsNotification.put("schedule", (Object) jsSchedule);
            }
            jsNotification.put("extra", notification.getExtra());
            jSArray.put(jsNotification);
        }
        jSObject.put("notifications", (Object) jSArray);
        return jSObject;
    }

    public int getSmallIcon(Context context, int defaultIcon) {
        int resId = 0;
        if (this.smallIcon != null) {
            resId = AssetUtil.getResourceID(context, this.smallIcon, "drawable");
        }
        if (resId == 0) {
            return defaultIcon;
        }
        return resId;
    }

    public Bitmap getLargeIcon(Context context) {
        if (this.largeIcon != null) {
            int resId = AssetUtil.getResourceID(context, this.largeIcon, "drawable");
            return BitmapFactory.decodeResource(context.getResources(), resId);
        }
        return null;
    }

    public boolean isScheduled() {
        return (this.schedule == null || (this.schedule.getOn() == null && this.schedule.getAt() == null && this.schedule.getEvery() == null)) ? false : true;
    }

    public String toString() {
        return "LocalNotification{title='" + this.title + "', body='" + this.body + "', id=" + this.id + ", sound='" + this.sound + "', smallIcon='" + this.smallIcon + "', iconColor='" + this.iconColor + "', actionTypeId='" + this.actionTypeId + "', group='" + this.group + "', extra=" + this.extra + ", attachments=" + this.attachments + ", schedule=" + this.schedule + ", groupSummary=" + this.groupSummary + ", ongoing=" + this.ongoing + ", autoCancel=" + this.autoCancel + '}';
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LocalNotification that = (LocalNotification) o;
        if (this.title == null ? that.title != null : !this.title.equals(that.title)) {
            return false;
        }
        if (this.body == null ? that.body != null : !this.body.equals(that.body)) {
            return false;
        }
        if (this.largeBody == null ? that.largeBody != null : !this.largeBody.equals(that.largeBody)) {
            return false;
        }
        if (this.id == null ? that.id != null : !this.id.equals(that.id)) {
            return false;
        }
        if (this.sound == null ? that.sound != null : !this.sound.equals(that.sound)) {
            return false;
        }
        if (this.smallIcon == null ? that.smallIcon != null : !this.smallIcon.equals(that.smallIcon)) {
            return false;
        }
        if (this.largeIcon == null ? that.largeIcon != null : !this.largeIcon.equals(that.largeIcon)) {
            return false;
        }
        if (this.iconColor == null ? that.iconColor != null : !this.iconColor.equals(that.iconColor)) {
            return false;
        }
        if (this.actionTypeId == null ? that.actionTypeId != null : !this.actionTypeId.equals(that.actionTypeId)) {
            return false;
        }
        if (this.group == null ? that.group != null : !this.group.equals(that.group)) {
            return false;
        }
        if (this.extra == null ? that.extra != null : !this.extra.equals(that.extra)) {
            return false;
        }
        if (this.attachments == null ? that.attachments != null : !this.attachments.equals(that.attachments)) {
            return false;
        }
        if (this.inboxList == null ? that.inboxList != null : !this.inboxList.equals(that.inboxList)) {
            return false;
        }
        if (this.groupSummary != that.groupSummary || this.ongoing != that.ongoing || this.autoCancel != that.autoCancel) {
            return false;
        }
        if (this.schedule != null) {
            return this.schedule.equals(that.schedule);
        }
        if (that.schedule == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = this.title != null ? this.title.hashCode() : 0;
        return (((((((((((((((((((((((((result * 31) + (this.body != null ? this.body.hashCode() : 0)) * 31) + (this.id != null ? this.id.hashCode() : 0)) * 31) + (this.sound != null ? this.sound.hashCode() : 0)) * 31) + (this.smallIcon != null ? this.smallIcon.hashCode() : 0)) * 31) + (this.iconColor != null ? this.iconColor.hashCode() : 0)) * 31) + (this.actionTypeId != null ? this.actionTypeId.hashCode() : 0)) * 31) + (this.group != null ? this.group.hashCode() : 0)) * 31) + Boolean.hashCode(this.groupSummary)) * 31) + Boolean.hashCode(this.ongoing)) * 31) + Boolean.hashCode(this.autoCancel)) * 31) + (this.extra != null ? this.extra.hashCode() : 0)) * 31) + (this.attachments != null ? this.attachments.hashCode() : 0)) * 31) + (this.schedule != null ? this.schedule.hashCode() : 0);
    }

    public void setExtraFromString(String extraFromString) {
        try {
            JSONObject jsonObject = new JSONObject(extraFromString);
            this.extra = JSObject.fromJSONObject(jsonObject);
        } catch (JSONException e) {
            Logger.error(Logger.tags("LN"), "Cannot rebuild extra data", e);
        }
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
