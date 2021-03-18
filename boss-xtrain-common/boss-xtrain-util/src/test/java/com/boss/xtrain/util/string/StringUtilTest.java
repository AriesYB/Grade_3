package com.boss.xtrain.util.string;

import com.boss.xtrain.util.date.DateType;
import com.boss.xtrain.util.date.DateUtil;
import org.junit.Test;

import java.text.ParseException;
import java.util.Date;

/**
 * @Description 字符串测试
 * @Date 2020/7/1 10:10
 * @Author HetFrame
 */
public class StringUtilTest {

    @Test
    public void isEmpty() {
    }

    @Test
    public void isNotEmpty() {
    }

    @Test
    public void isBlank() {
    }

    @Test
    public void isNotBlank() {
    }

    @Test
    public void trim() throws ParseException {
        Date date = DateUtil.getInstance().parseDate("2020-07-01 11:49:40", DateType.YYYY_MM_DD_HH_MM_SS_HYPHEN);
        System.out.println("增加运算");
        Date date1 = DateUtil.getInstance().addYears(date,1);
        System.out.println(DateUtil.getInstance().formatDate(date1,DateType.YYYY_MM_DD_HH_MM_SS_HYPHEN));
        Date date2 = DateUtil.getInstance().addMonths(date,1);
        System.out.println(DateUtil.getInstance().formatDate(date2, DateType.YYYY_MM_DD_HH_MM_SS_HYPHEN));
        Date date3 = DateUtil.getInstance().addWeeks(date,1);
        System.out.println(DateUtil.getInstance().formatDate(date3, DateType.YYYY_MM_DD_HH_MM_SS_HYPHEN));
        Date date4 = DateUtil.getInstance().addDays(date,1);
        System.out.println(DateUtil.getInstance().formatDate(date4, DateType.YYYY_MM_DD_HH_MM_SS_HYPHEN));
        Date date5 =DateUtil.getInstance().addHours(date,1);
        System.out.println(DateUtil.getInstance().formatDate(date5, DateType.YYYY_MM_DD_HH_MM_SS_HYPHEN));
        Date date6 =DateUtil.getInstance().addMinutes(date,1);
        System.out.println(DateUtil.getInstance().formatDate(date6, DateType.YYYY_MM_DD_HH_MM_SS_HYPHEN));
        Date date7 =DateUtil.getInstance().addSeconds(date,1);
        System.out.println(DateUtil.getInstance().formatDate(date7, DateType.YYYY_MM_DD_HH_MM_SS_HYPHEN));
        Date date8 =DateUtil.getInstance().addMilliseconds(date,1);
        System.out.println(DateUtil.getInstance().formatDate(date8, DateType.YYYY_MM_DD_HH_MM_SS_HYPHEN));

        String date9 = DateUtil.getInstance().formatDate(date);
        System.out.println(date9);

    }

    @Test
    public void trimToNull() {
    }

    @Test
    public void trimToEmpty() {
    }
}