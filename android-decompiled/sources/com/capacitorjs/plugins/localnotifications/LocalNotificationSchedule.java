package com.capacitorjs.plugins.localnotifications;

import com.getcapacitor.JSObject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import kotlinx.coroutines.DebugKt;

/* loaded from: classes9.dex */
public class LocalNotificationSchedule {
    public static String JS_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    private Date at;
    private Integer count;
    private String every;
    private DateMatch on;
    private Boolean repeats;
    private JSObject scheduleObj;
    private Boolean whileIdle;

    public LocalNotificationSchedule(JSObject schedule) throws ParseException {
        this.scheduleObj = schedule;
        buildEveryElement(schedule);
        buildCountElement(schedule);
        buildAtElement(schedule);
        buildOnElement(schedule);
        this.whileIdle = schedule.getBoolean("allowWhileIdle", false);
    }

    public LocalNotificationSchedule() {
    }

    private void buildEveryElement(JSObject schedule) {
        this.every = schedule.getString("every");
    }

    private void buildCountElement(JSObject schedule) {
        this.count = schedule.getInteger("count", 1);
    }

    private void buildAtElement(JSObject schedule) throws ParseException {
        this.repeats = schedule.getBool("repeats");
        String dateString = schedule.getString("at");
        if (dateString != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(JS_DATE_FORMAT);
            sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
            this.at = sdf.parse(dateString);
        }
    }

    private void buildOnElement(JSObject schedule) {
        JSObject onJson = schedule.getJSObject(DebugKt.DEBUG_PROPERTY_VALUE_ON);
        if (onJson != null) {
            this.on = new DateMatch();
            this.on.setYear(onJson.getInteger("year"));
            this.on.setMonth(onJson.getInteger("month"));
            this.on.setDay(onJson.getInteger("day"));
            this.on.setWeekday(onJson.getInteger("weekday"));
            this.on.setHour(onJson.getInteger("hour"));
            this.on.setMinute(onJson.getInteger("minute"));
            this.on.setSecond(onJson.getInteger("second"));
        }
    }

    public DateMatch getOn() {
        return this.on;
    }

    public JSObject getOnObj() {
        return this.scheduleObj.getJSObject(DebugKt.DEBUG_PROPERTY_VALUE_ON);
    }

    public void setOn(DateMatch on) {
        this.on = on;
    }

    public Date getAt() {
        return this.at;
    }

    public void setAt(Date at) {
        this.at = at;
    }

    public Boolean getRepeats() {
        return this.repeats;
    }

    public void setRepeats(Boolean repeats) {
        this.repeats = repeats;
    }

    public String getEvery() {
        return this.every;
    }

    public void setEvery(String every) {
        this.every = every;
    }

    public int getCount() {
        return this.count.intValue();
    }

    public void setCount(int count) {
        this.count = Integer.valueOf(count);
    }

    public boolean allowWhileIdle() {
        return this.whileIdle.booleanValue();
    }

    public boolean isRepeating() {
        return Boolean.TRUE.equals(this.repeats);
    }

    public boolean isRemovable() {
        if (this.every == null && this.on == null) {
            if (this.at != null) {
                return !isRepeating();
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Long getEveryInterval() {
        switch (this.every) {
            case "year":
                return Long.valueOf(this.count.intValue() * 604800000 * 52);
            case "month":
                return Long.valueOf(this.count.intValue() * 30 * 86400000);
            case "two-weeks":
                return Long.valueOf(this.count.intValue() * 2 * 604800000);
            case "week":
                return Long.valueOf(this.count.intValue() * 604800000);
            case "day":
                return Long.valueOf(this.count.intValue() * 86400000);
            case "hour":
                return Long.valueOf(this.count.intValue() * 3600000);
            case "minute":
                return Long.valueOf(this.count.intValue() * 60000);
            case "second":
                return Long.valueOf(this.count.intValue() * 1000);
            default:
                return null;
        }
    }

    public Long getNextOnSchedule(Date currentTime) {
        return Long.valueOf(this.on.nextTrigger(currentTime));
    }
}
