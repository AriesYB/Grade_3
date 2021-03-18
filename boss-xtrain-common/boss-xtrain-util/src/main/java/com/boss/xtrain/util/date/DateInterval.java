package com.boss.xtrain.util.date;

/**
 * @Description 日期的间隔
 * @Date 2020/7/1 17:55
 * @Author HetFrame
 */

public class DateInterval {
    private long years;
    private long days;
    private long hours;
    private long minutes;
    private long seconds;

    public DateInterval() {
    }

    /**
    * @Description 将毫秒进行分割
    * @date 2020/7/1 22:05
    * @param time 时间(单位毫秒)
    * @return: null
    */
    public DateInterval(long time) {
        years = (time / (1000 * 60 * 60 * 24)) / 365;
        days = time / (1000 * 60 * 60 * 24) - years * 365;
        hours = time / (1000 * 60 * 60) - years * 365 * 24 - days * 24;
        minutes = time / (1000 * 60) - years * 365 * 24 * 60 - days * 24 * 60 - hours * 60;
        seconds = time / 1000 - years * 365 * 24 * 60 * 60 - days * 24 * 60 * 60 - hours * 60 * 60 - minutes * 60;
    }

    public int getIntervalDay(){
        return (int) (years*365+days);
    }

    public int getIntervalHours(){
        return (int) (years*365*24+days*24+hours);
    }

    public DateInterval(long years, long days, long hours, long minutes, long seconds) {
        this.years = years;
        this.days = days;
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public long getYears() {
        return years;
    }

    public void setYears(long years) {
        this.years = years;
    }

    public long getDays() {
        return days;
    }

    public void setDays(long days) {
        this.days = days;
    }

    public long getHours() {
        return hours;
    }

    public void setHours(long hours) {
        this.hours = hours;
    }

    public long getMinutes() {
        return minutes;
    }

    public void setMinutes(long minutes) {
        this.minutes = minutes;
    }

    public long getSeconds() {
        return seconds;
    }

    public void setSeconds(long seconds) {
        this.seconds = seconds;
    }

    @Override
    public String toString() {
        return "DateInterval{" +
                "years=" + years +
                ", days=" + days +
                ", hours=" + hours +
                ", minutes=" + minutes +
                ", seconds=" + seconds +
                '}';
    }
}
