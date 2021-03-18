package com.boss.xtrain.util.date;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.FastDateFormat;

import java.text.ParseException;
import java.util.Date;

/**
 * @Description 封装apache时间工具
 * @Date 2020/7/1 10:19
 * @Author HetFrame
 */
public class DateUtil {

    private static DateUtil instance;


    private DateUtil() {
        // 私有无参构造器
    }

    public static DateUtil getInstance() {
        if (instance == null) {
            synchronized (DateUtil.class) {
                if (instance == null) {
                    instance = new DateUtil();
                }
            }
        }
        return instance;
    }

    /**
     * @Description 获取当前时间
     * @date 2020/7/2 22:43
     * @return: java.util.Date
     */
    public Date getCurrentTime() {
        return new Date(System.currentTimeMillis());
    }

    /**
     * @Description 获取当前时间字符串
     * @date 2020/7/2 22:43
     * @return: java.util.Date
     */
    public String getCurrentTimeString() {
        return formatDate(new Date(System.currentTimeMillis()), DateType.YYYY_MM_DD_HH_MM_SS_HYPHEN);
    }

    /**
     * @param type 指定时间格式类型
     * @Description 获取当前时间字符串
     * @date 2020/7/2 22:43
     * @return: java.util.Date
     */
    public String getCurrentTimeString(DateType type) {
        return formatDate(new Date(System.currentTimeMillis()), type);
    }

    /**
     * @param date 待转换的日期
     * @param type 需要转换成的类型
     * @Description 将Date对象转换日期时间字符串，需要指定日期格式类型
     * @date 2020/7/1 10:41
     * @return: java.lang.String
     */
    public String formatDate(Date date, DateType type) {
        String formatDate = null;
        if (date != null) {
            formatDate = FastDateFormat.getInstance(type.getValue()).format(date);
        }
        return formatDate;
    }

    /**
     * @param date 待转换的日期
     * @Description 将Date对象转换日期时间字符串, 默认年-月-日 时:分:秒
     * @date 2020/7/1 10:41
     * @return: java.lang.String
     */
    public String formatDate(Date date) {
        String formatDate = null;
        if (date != null) {
            formatDate = FastDateFormat.getInstance(DateType.YYYY_MM_DD_HH_MM_SS_HYPHEN.getValue()).format(date);
        }
        return formatDate;
    }

    /**
     * @param dateString 待转换的日期字符串
     * @param type       字符串的类型
     * @Description 将日期字符转换成Date对象，需要指定日期格式类型。若格式不正确则抛出ParseException
     * @date 2020/7/1 11:51
     * @return: java.util.Date
     */
    public Date parseDate(String dateString, DateType type) throws ParseException {
        return DateUtils.parseDate(dateString, type.getValue());
    }


    /**
     * @param date1 日期1
     * @param date2 日期2
     * @Description 判断是否是同一天
     * @date 2020/7/1 12:30
     * @return: boolean
     */
    public boolean isSameDay(Date date1, Date date2) {
        return DateUtils.isSameDay(date1, date2);
    }

    /**
     * @param date       日期
     * @param dateString 日期字符串
     * @param type       日期字符串格式类型
     * @Description 判断是否是同一天，Date跟字符串，需要指定日期格式类型
     * @date 2020/7/1 12:33
     * @return: boolean
     */
    public boolean isSameDay(Date date, String dateString, DateType type) throws ParseException {
        return DateUtils.isSameDay(date, parseDate(dateString, type));
    }

    /**
     * @param dateString1 日期字符串1
     * @param dateString2 日期字符串2
     * @Description 日期字符串进行比较，需要指定日期格式类型
     * @date 2020/7/1 12:36
     * @return: boolean
     */
    public boolean isSameDay(String dateString1, String dateString2, DateType type) throws ParseException {
        return DateUtils.isSameDay(parseDate(dateString1, type), parseDate(dateString2, type));
    }

    /**
     * @param date1 日期1
     * @param date2 日期2
     * @Description 是否为同一时刻
     * @date 2020/7/1 16:41
     * @return: boolean
     */
    public boolean isSameInstant(Date date1, Date date2) {
        return DateUtils.isSameInstant(date1, date2);
    }

    /**
     * @param dateString1 日期字符串1
     * @param dateString2 日期字符串2
     * @param type
     * @Description 是否为同一时刻，需要指定日期格式类型
     * @date 2020/7/1 16:43
     * @return: boolean
     */
    public boolean isSameInstant(String dateString1, String dateString2, DateType type) throws ParseException {
        return DateUtils.isSameInstant(parseDate(dateString1, type), parseDate(dateString2, type));
    }

    /**
     * @param date1 日期1
     * @param date2 日期2
     * @Description 比较两个日期，若date1>date2，返回1;小于返回0
     * @date 2020/7/1 16:33
     * @return: int
     */
    public int compareDate(Date date1, Date date2) {
        if (date1 != null && date2 != null) {
            return date1.getTime() > date2.getTime() ? 1 : 0;
        } else {
            throw new IllegalArgumentException("date不能为空!");
        }
    }

    /**
     * @param dateString1 日期字符串1
     * @param dateString2 日期字符串2
     * @param type        日期字符串的类型
     * @Description 比较两个日期字符串，需要指定日期格式类型。若date1>date2，返回1;小于返回0
     * @date 2020/7/1 16:33
     * @return: int
     */
    public int compareDate(String dateString1, String dateString2, DateType type) throws ParseException {
        Date date1 = parseDate(dateString1, type);
        Date date2 = parseDate(dateString2, type);
        if (date1 != null && date2 != null) {
            return date1.getTime() > date2.getTime() ? 1 : 0;
        } else {
            throw new IllegalArgumentException("date不能为空!");
        }
    }

    /**
     * @param date1 日期1
     * @param date2 日期2
     * @Description 获取两个日期时间间隔，不区分先后
     * @date 2020/7/1 18:01
     * @return: com.boss.xtrain.util.date.DateInterval
     */
    public DateInterval getInterval(Date date1, Date date2) {
        long time = date1.getTime() - date2.getTime() < 0 ? date2.getTime() - date1.getTime() : date1.getTime() - date2.getTime();
        return new DateInterval(time);
    }

    /**
     * @param dateString1 日期字符串1
     * @param dateString2 日期字符串2
     * @param type        日期字符串的格式类型
     * @Description 获取两个日期时间间隔，不区分先后
     * @date 2020/7/1 19:27
     * @return: com.boss.xtrain.util.date.DateInterval
     */
    public DateInterval getInterval(String dateString1, String dateString2, DateType type) throws ParseException {
        Date date1 = parseDate(dateString1, type);
        Date date2 = parseDate(dateString2, type);
        long time = date1.getTime() - date2.getTime() < 0 ? date2.getTime() - date1.getTime() : date1.getTime() - date2.getTime();
        return new DateInterval(time);
    }


    /**
     * @param date   日期
     * @param amount 增加的数量，若为负则减少
     * @Description 增加年份运算
     * @date 2020/7/1 12:37
     * @return: java.util.Date
     */
    public Date addYears(Date date, int amount) {
        return DateUtils.addYears(date, amount);
    }

    /**
     * @param date   日期
     * @param amount 增加的数量，若为负则减少
     * @Description 增加月份运算
     * @date 2020/7/1 12:37
     * @return: java.util.Date
     */
    public Date addMonths(Date date, int amount) {
        return DateUtils.addMonths(date, amount);
    }

    /**
     * @param date   日期
     * @param amount 增加的数量，若为负则减少
     * @Description 增加周运算
     * @date 2020/7/1 12:37
     * @return: java.util.Date
     */
    public Date addWeeks(Date date, int amount) {
        return DateUtils.addWeeks(date, amount);
    }

    /**
     * @param date   日期
     * @param amount 增加的数量，若为负则减少
     * @Description 增加天数运算
     * @date 2020/7/1 12:37
     * @return: java.util.Date
     */
    public Date addDays(Date date, int amount) {
        return DateUtils.addDays(date, amount);
    }

    /**
     * @param date   日期
     * @param amount 增加的数量，若为负则减少
     * @Description 增加小时运算
     * @date 2020/7/1 12:37
     * @return: java.util.Date
     */
    public Date addHours(Date date, int amount) {
        return DateUtils.addHours(date, amount);
    }

    /**
     * @param date   日期
     * @param amount 增加的数量，若为负则减少
     * @Description 增加分钟运算
     * @date 2020/7/1 12:37
     * @return: java.util.Date
     */
    public Date addMinutes(Date date, int amount) {
        return DateUtils.addMinutes(date, amount);
    }

    /**
     * @param date   日期
     * @param amount 增加的数量，若为负则减少
     * @Description 增加秒运算
     * @date 2020/7/1 12:37
     * @return: java.util.Date
     */
    public Date addSeconds(Date date, int amount) {
        return DateUtils.addSeconds(date, amount);
    }

    /**
     * @param date   日期
     * @param amount 增加的数量，若为负则减少
     * @Description 增加毫秒运算
     * @date 2020/7/1 12:37
     * @return: java.util.Date
     */
    public Date addMilliseconds(Date date, int amount) {
        return DateUtils.addMilliseconds(date, amount);
    }

    /**
     * @param date   日期
     * @param amount 数量
     * @Description 设置年份运算
     * @date 2020/7/1 12:37
     * @return: java.util.Date
     */
    public Date setYears(Date date, int amount) {
        return DateUtils.setYears(date, amount);
    }

    /**
     * @param date   日期
     * @param amount 数量
     * @Description 设置月份运算
     * @date 2020/7/1 12:37
     * @return: java.util.Date
     */
    public Date setMonths(Date date, int amount) {
        return DateUtils.setMonths(date, amount);
    }

    /**
     * @param date   日期
     * @param amount 数量
     * @Description 设置天数运算
     * @date 2020/7/1 12:37
     * @return: java.util.Date
     */
    public Date setDays(Date date, int amount) {
        return DateUtils.setDays(date, amount);
    }

    /**
     * @param date   日期
     * @param amount 数量
     * @Description 设置小时运算
     * @date 2020/7/1 12:37
     * @return: java.util.Date
     */
    public Date setHours(Date date, int amount) {
        return DateUtils.setHours(date, amount);
    }

    /**
     * @param date   日期
     * @param amount 数量
     * @Description 设置分钟运算
     * @date 2020/7/1 12:37
     * @return: java.util.Date
     */
    public Date setMinutes(Date date, int amount) {
        return DateUtils.setMinutes(date, amount);
    }

    /**
     * @param date   日期
     * @param amount 数量
     * @Description 设置秒运算
     * @date 2020/7/1 12:37
     * @return: java.util.Date
     */
    public Date setSeconds(Date date, int amount) {
        return DateUtils.setSeconds(date, amount);
    }

}
