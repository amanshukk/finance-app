package com.capacitorjs.plugins.localnotifications;

import androidx.webkit.ProxyConfig;
import java.util.Calendar;
import java.util.Date;

/* loaded from: classes9.dex */
public class DateMatch {
    private static final String separator = " ";
    private Integer day;
    private Integer hour;
    private Integer minute;
    private Integer month;
    private Integer second;
    private Integer unit = -1;
    private Integer weekday;
    private Integer year;

    public Integer getYear() {
        return this.year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return this.month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return this.day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getWeekday() {
        return this.weekday;
    }

    public void setWeekday(Integer weekday) {
        this.weekday = weekday;
    }

    public Integer getHour() {
        return this.hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public Integer getMinute() {
        return this.minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    public Integer getSecond() {
        return this.second;
    }

    public void setSecond(Integer second) {
        this.second = second;
    }

    private Calendar buildCalendar(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(14, 0);
        return cal;
    }

    public long nextTrigger(Date date) {
        Calendar current = buildCalendar(date);
        Calendar next = buildNextTriggerTime(date);
        return postponeTriggerIfNeeded(current, next);
    }

    private long postponeTriggerIfNeeded(Calendar current, Calendar next) {
        if (next.getTimeInMillis() <= current.getTimeInMillis() && this.unit.intValue() != -1) {
            Integer incrementUnit = -1;
            if (this.unit.intValue() == 1 || this.unit.intValue() == 2) {
                incrementUnit = 1;
            } else if (this.unit.intValue() == 5) {
                incrementUnit = 2;
            } else if (this.unit.intValue() == 7) {
                incrementUnit = 4;
            } else if (this.unit.intValue() == 11) {
                incrementUnit = 5;
            } else if (this.unit.intValue() == 12) {
                incrementUnit = 11;
            } else if (this.unit.intValue() == 13) {
                incrementUnit = 12;
            }
            if (incrementUnit.intValue() != -1) {
                next.set(incrementUnit.intValue(), next.get(incrementUnit.intValue()) + 1);
            }
        }
        return next.getTimeInMillis();
    }

    private Calendar buildNextTriggerTime(Date date) {
        Calendar next = buildCalendar(date);
        if (this.year != null) {
            next.set(1, this.year.intValue());
            if (this.unit.intValue() == -1) {
                this.unit = 1;
            }
        }
        if (this.month != null) {
            next.set(2, this.month.intValue());
            if (this.unit.intValue() == -1) {
                this.unit = 2;
            }
        }
        if (this.day != null) {
            next.set(5, this.day.intValue());
            if (this.unit.intValue() == -1) {
                this.unit = 5;
            }
        }
        if (this.weekday != null) {
            next.set(7, this.weekday.intValue());
            if (this.unit.intValue() == -1) {
                this.unit = 7;
            }
        }
        if (this.hour != null) {
            next.set(11, this.hour.intValue());
            if (this.unit.intValue() == -1) {
                this.unit = 11;
            }
        }
        if (this.minute != null) {
            next.set(12, this.minute.intValue());
            if (this.unit.intValue() == -1) {
                this.unit = 12;
            }
        }
        if (this.second != null) {
            next.set(13, this.second.intValue());
            if (this.unit.intValue() == -1) {
                this.unit = 13;
            }
        }
        return next;
    }

    public String toString() {
        return "DateMatch{year=" + this.year + ", month=" + this.month + ", day=" + this.day + ", weekday=" + this.weekday + ", hour=" + this.hour + ", minute=" + this.minute + ", second=" + this.second + '}';
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DateMatch dateMatch = (DateMatch) o;
        if (this.year == null ? dateMatch.year != null : !this.year.equals(dateMatch.year)) {
            return false;
        }
        if (this.month == null ? dateMatch.month != null : !this.month.equals(dateMatch.month)) {
            return false;
        }
        if (this.day == null ? dateMatch.day != null : !this.day.equals(dateMatch.day)) {
            return false;
        }
        if (this.weekday == null ? dateMatch.weekday != null : !this.weekday.equals(dateMatch.weekday)) {
            return false;
        }
        if (this.hour == null ? dateMatch.hour != null : !this.hour.equals(dateMatch.hour)) {
            return false;
        }
        if (this.minute == null ? dateMatch.minute != null : !this.minute.equals(dateMatch.minute)) {
            return false;
        }
        if (this.second != null) {
            return this.second.equals(dateMatch.second);
        }
        if (dateMatch.second == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = this.year != null ? this.year.hashCode() : 0;
        return (((((((((result * 31) + (this.month != null ? this.month.hashCode() : 0)) * 31) + (this.day != null ? this.day.hashCode() : 0)) * 31) + (this.weekday != null ? this.weekday.hashCode() : 0)) * 31) + (this.hour != null ? this.hour.hashCode() : 0)) * 31) + (this.minute != null ? this.minute.hashCode() : 0) + 31 + (this.second != null ? this.second.hashCode() : 0);
    }

    public String toMatchString() {
        String matchString = this.year + separator + this.month + separator + this.day + separator + this.weekday + separator + this.hour + separator + this.minute + separator + this.second + separator + this.unit;
        return matchString.replace("null", ProxyConfig.MATCH_ALL_SCHEMES);
    }

    public static DateMatch fromMatchString(String matchString) {
        DateMatch date = new DateMatch();
        String[] split = matchString.split(separator);
        if (split != null && split.length == 7) {
            date.setYear(getValueFromCronElement(split[0]));
            date.setMonth(getValueFromCronElement(split[1]));
            date.setDay(getValueFromCronElement(split[2]));
            date.setWeekday(getValueFromCronElement(split[3]));
            date.setHour(getValueFromCronElement(split[4]));
            date.setMinute(getValueFromCronElement(split[5]));
            date.setUnit(getValueFromCronElement(split[6]));
        }
        if (split != null && split.length == 8) {
            date.setYear(getValueFromCronElement(split[0]));
            date.setMonth(getValueFromCronElement(split[1]));
            date.setDay(getValueFromCronElement(split[2]));
            date.setWeekday(getValueFromCronElement(split[3]));
            date.setHour(getValueFromCronElement(split[4]));
            date.setMinute(getValueFromCronElement(split[5]));
            date.setSecond(getValueFromCronElement(split[6]));
            date.setUnit(getValueFromCronElement(split[7]));
        }
        return date;
    }

    public static Integer getValueFromCronElement(String token) {
        try {
            return Integer.valueOf(Integer.parseInt(token));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public Integer getUnit() {
        return this.unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }
}
