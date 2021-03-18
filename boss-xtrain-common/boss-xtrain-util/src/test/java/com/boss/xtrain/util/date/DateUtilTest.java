package com.boss.xtrain.util.date;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @Description 测试DateUtil
 * @Date 2020/7/1 18:54
 * @Author HetFrame
 */
public class DateUtilTest {

    private static final Logger log = LoggerFactory.getLogger(DateUtilTest.class);

    @Test
    public void getCurrentTime() {
        log.info("当前时间:{}",DateUtil.getInstance().getCurrentTime());
    }

    @Test
    public void getCurrentTimeString() {
        log.info("当前时间:{}",DateUtil.getInstance().getCurrentTimeString());
    }

    @Test
    public void formatDate() {
        Date date = new Date();
        String dateString = DateUtil.getInstance().formatDate(date);
        log.info("默认的日期格式:{}", dateString);
    }

    @Test
    public void testFormatDate() {
        Date date = new Date();
        String dateString = DateUtil.getInstance().formatDate(date, DateType.YYYY_MM_DD_HH_MM_SS_DOT);
        String dateString1 = DateUtil.getInstance().formatDate(date, DateType.YYYY_MM_DD_HH_MM_SS_SLASH);
        String dateString2 = DateUtil.getInstance().formatDate(date, DateType.YYYY_MM_DD_HH_MM_SS_ZH);
        String dateString3 = DateUtil.getInstance().formatDate(date, DateType.YYYY_MM_DD_HH_MM_SS_HYPHEN);
        log.info("日期格式:{} 日期:{}", DateType.YYYY_MM_DD_HH_MM_SS_DOT.getValue(), dateString);
        log.info("日期格式:{} 日期:{}", DateType.YYYY_MM_DD_HH_MM_SS_SLASH.getValue(), dateString1);
        log.info("日期格式:{} 日期:{}", DateType.YYYY_MM_DD_HH_MM_SS_ZH.getValue(), dateString2);
        log.info("日期格式:{} 日期:{}", DateType.YYYY_MM_DD_HH_MM_SS_HYPHEN.getValue(), dateString3);
    }

    @Test
    public void parseDate() {
        try {
            String dateString = "2020-07-01 19:13:21";
            Date date = DateUtil.getInstance().parseDate(dateString, DateType.YYYY_MM_DD_HH_MM_SS_HYPHEN);
            log.info("转化成的date:{}", date);
        } catch (ParseException e) {
            log.error(e.getMessage());
        }
    }

    @Test
    public void isSameDay() {
        try {
            String dateString = "2020-07-01 19:13:21";
            String dateString1 = "2020-07-01 05:12:35";
            String dateString2 = "2020-07-02 05:12:35";
            assertTrue(DateUtil.getInstance().isSameDay(dateString, dateString1, DateType.YYYY_MM_DD_HH_MM_SS_HYPHEN));
            assertFalse(DateUtil.getInstance().isSameDay(dateString, dateString2, DateType.YYYY_MM_DD_HH_MM_SS_HYPHEN));
        } catch (ParseException e) {
            log.error(e.getMessage());
        }
    }

    @Test
    public void isSameInstant() {
        try {
            String dateString = "2020-07-01 19:13:21";
            String dateString1 = "2020-07-01 05:12:35";
            String dateString2 = "2020-07-01 05:12:35";
            assertFalse(DateUtil.getInstance().isSameInstant(dateString, dateString1, DateType.YYYY_MM_DD_HH_MM_SS_HYPHEN));
            assertTrue(DateUtil.getInstance().isSameInstant(dateString1, dateString2, DateType.YYYY_MM_DD_HH_MM_SS_HYPHEN));
        } catch (ParseException e) {
            log.error(e.getMessage());
        }
    }

    @Test
    public void compareDate() {
        try {
            String dateString = "2020-07-01 19:13:21";
            String dateString1 = "2020-07-01 05:12:35";
            String dateString2 = "2020-07-02 05:12:35";
            assertEquals(1, DateUtil.getInstance().compareDate(dateString, dateString1, DateType.YYYY_MM_DD_HH_MM_SS_HYPHEN));
            assertEquals(0, DateUtil.getInstance().compareDate(dateString1, dateString2, DateType.YYYY_MM_DD_HH_MM_SS_HYPHEN));
        } catch (ParseException e) {
            log.error(e.getMessage());
        }
    }

    @Test
    public void getInterval() {
        try {
            String dateString = "2020-07-01 19:13:21";
            String dateString1 = "2020-07-01 05:12:35";
            String dateString2 = "2020-07-02 15:46:35";
            DateInterval dateInterval = DateUtil.getInstance().getInterval(dateString, dateString1, DateType.YYYY_MM_DD_HH_MM_SS_HYPHEN);
            DateInterval dateInterval1 = DateUtil.getInstance().getInterval(dateString2, dateString1, DateType.YYYY_MM_DD_HH_MM_SS_HYPHEN);
            log.info("求{}和{}日期差:{} 转化成天:{} 和小时:{}", dateString, dateString1, dateInterval, dateInterval.getIntervalDay(), dateInterval.getIntervalHours());
            log.info("求{}和{}日期差:{} 转化成天:{} 和小时:{}", dateString1, dateString2, dateInterval1, dateInterval1.getIntervalDay(), dateInterval1.getIntervalHours());
        } catch (ParseException e) {
            log.error(e.getMessage());
        }
    }

    @Test
    public void addYears() {
        try {
            String dateString = "2020-07-01 19:13:21";
            int amount = 5;
            Date date = DateUtil.getInstance().parseDate(dateString, DateType.YYYY_MM_DD_HH_MM_SS_HYPHEN);
            Date date1 = DateUtil.getInstance().addYears(date, amount);
            String dateString1 = DateUtil.getInstance().formatDate(date1);
            log.info("{} 增加{}年:{}", dateString, amount, dateString1);
        } catch (ParseException e) {
            log.error(e.getMessage());
        }
    }

    @Test
    public void addMonths() {
        try {
            String dateString = "2020-07-01 19:13:21";
            int amount = 8;
            Date date = DateUtil.getInstance().parseDate(dateString, DateType.YYYY_MM_DD_HH_MM_SS_HYPHEN);
            Date date1 = DateUtil.getInstance().addMonths(date, amount);
            String dateString1 = DateUtil.getInstance().formatDate(date1);
            log.info("{} 增加{}月:{}", dateString, amount, dateString1);
        } catch (ParseException e) {
            log.error(e.getMessage());
        }
    }

    @Test
    public void addWeeks() {
        try {
            String dateString = "2020-07-01 19:13:21";
            int amount = 2;
            Date date = DateUtil.getInstance().parseDate(dateString, DateType.YYYY_MM_DD_HH_MM_SS_HYPHEN);
            Date date1 = DateUtil.getInstance().addWeeks(date, amount);
            String dateString1 = DateUtil.getInstance().formatDate(date1);
            log.info("{} 增加{}周:{}", dateString, amount, dateString1);
        } catch (ParseException e) {
            log.error(e.getMessage());
        }
    }

    @Test
    public void addDays() {
        try {
            String dateString = "2020-07-01 19:13:21";
            int amount = 31;
            Date date = DateUtil.getInstance().parseDate(dateString, DateType.YYYY_MM_DD_HH_MM_SS_HYPHEN);
            Date date1 = DateUtil.getInstance().addDays(date, amount);
            String dateString1 = DateUtil.getInstance().formatDate(date1);
            log.info("{} 增加{}天:{}", dateString, amount, dateString1);
        } catch (ParseException e) {
            log.error(e.getMessage());
        }
    }

    @Test
    public void addHours() {
        try {
            String dateString = "2020-07-01 19:13:21";
            int amount = 25;
            Date date = DateUtil.getInstance().parseDate(dateString, DateType.YYYY_MM_DD_HH_MM_SS_HYPHEN);
            Date date1 = DateUtil.getInstance().addHours(date, amount);
            String dateString1 = DateUtil.getInstance().formatDate(date1);
            log.info("{} 增加{}小时:{}", dateString, amount, dateString1);
        } catch (ParseException e) {
            log.error(e.getMessage());
        }
    }

    @Test
    public void addMinutes() {
        try {
            String dateString = "2020-07-01 19:13:21";
            int amount = 61;
            Date date = DateUtil.getInstance().parseDate(dateString, DateType.YYYY_MM_DD_HH_MM_SS_HYPHEN);
            Date date1 = DateUtil.getInstance().addMinutes(date, amount);
            String dateString1 = DateUtil.getInstance().formatDate(date1);
            log.info("{} 增加{}分钟:{}", dateString, amount, dateString1);
        } catch (ParseException e) {
            log.error(e.getMessage());
        }
    }

    @Test
    public void addSeconds() {
        try {
            String dateString = "2020-07-01 19:13:21";
            int amount = 40;
            Date date = DateUtil.getInstance().parseDate(dateString, DateType.YYYY_MM_DD_HH_MM_SS_HYPHEN);
            Date date1 = DateUtil.getInstance().addSeconds(date, amount);
            String dateString1 = DateUtil.getInstance().formatDate(date1);
            log.info("{} 增加{}秒:{}", dateString, amount, dateString1);
        } catch (ParseException e) {
            log.error(e.getMessage());
        }
    }

    @Test
    public void addMilliseconds() {
        try {
            String dateString = "2020-07-01 19:13:21";
            int amount = 2000;
            Date date = DateUtil.getInstance().parseDate(dateString, DateType.YYYY_MM_DD_HH_MM_SS_HYPHEN);
            Date date1 = DateUtil.getInstance().addMilliseconds(date, amount);
            String dateString1 = DateUtil.getInstance().formatDate(date1);
            log.info("{} 增加{}毫秒:{}", dateString, amount, dateString1);
        } catch (ParseException e) {
            log.error(e.getMessage());
        }
    }

    @Test
    public void setYears() {
        try {
            String dateString = "2020-07-01 19:13:21";
            int amount = 2002;
            Date date = DateUtil.getInstance().parseDate(dateString, DateType.YYYY_MM_DD_HH_MM_SS_HYPHEN);
            Date date1 = DateUtil.getInstance().setYears(date, amount);
            String dateString1 = DateUtil.getInstance().formatDate(date1);
            log.info("{} 设置为{}年:{}", dateString, amount, dateString1);
        } catch (ParseException e) {
            log.error(e.getMessage());
        }
    }

    @Test
    public void setMonths() {
        try {
            String dateString = "2020-07-01 19:13:21";
            int amount = 10;
            Date date = DateUtil.getInstance().parseDate(dateString, DateType.YYYY_MM_DD_HH_MM_SS_HYPHEN);
            Date date1 = DateUtil.getInstance().setMonths(date, amount);
            String dateString1 = DateUtil.getInstance().formatDate(date1);
            log.info("{} 设置为{}月份:{}", dateString, amount, dateString1);
        } catch (ParseException e) {
            log.error(e.getMessage());
        }
    }

    @Test
    public void setDays() {
        try {
            String dateString = "2020-07-01 19:13:21";
            int amount = 31;
            Date date = DateUtil.getInstance().parseDate(dateString, DateType.YYYY_MM_DD_HH_MM_SS_HYPHEN);
            Date date1 = DateUtil.getInstance().setDays(date, amount);
            String dateString1 = DateUtil.getInstance().formatDate(date1);
            log.info("{} 设置为{}天:{}", dateString, amount, dateString1);
        } catch (ParseException e) {
            log.error(e.getMessage());
        }
    }

    @Test
    public void setHours() {
        try {
            String dateString = "2020-07-01 19:13:21";
            int amount = 8;
            Date date = DateUtil.getInstance().parseDate(dateString, DateType.YYYY_MM_DD_HH_MM_SS_HYPHEN);
            Date date1 = DateUtil.getInstance().setHours(date, amount);
            String dateString1 = DateUtil.getInstance().formatDate(date1);
            log.info("{} 设置为{}时:{}", dateString, amount, dateString1);
        } catch (ParseException e) {
            log.error(e.getMessage());
        }
    }

    @Test
    public void setMinutes() {
        try {
            String dateString = "2020-07-01 19:13:21";
            int amount = 31;
            Date date = DateUtil.getInstance().parseDate(dateString, DateType.YYYY_MM_DD_HH_MM_SS_HYPHEN);
            Date date1 = DateUtil.getInstance().setMinutes(date, amount);
            String dateString1 = DateUtil.getInstance().formatDate(date1);
            log.info("{} 设置为{}分钟:{}", dateString, amount, dateString1);
        } catch (ParseException e) {
            log.error(e.getMessage());
        }
    }

    @Test
    public void setSeconds() {
        try {
            String dateString = "2020-07-01 19:13:21";
            int amount = 1;
            Date date = DateUtil.getInstance().parseDate(dateString, DateType.YYYY_MM_DD_HH_MM_SS_HYPHEN);
            Date date1 = DateUtil.getInstance().setSeconds(date, amount);
            String dateString1 = DateUtil.getInstance().formatDate(date1);
            log.info("{} 设置为{}秒:{}", dateString, amount, dateString1);
        } catch (ParseException e) {
            log.error(e.getMessage());
        }
    }

}