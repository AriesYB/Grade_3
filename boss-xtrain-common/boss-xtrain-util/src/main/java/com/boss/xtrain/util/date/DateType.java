package com.boss.xtrain.util.date;

/**
 * @Description 日期类型
 * @Date 2020/7/1 15:50
 * @Author HetFrame
 */
public enum DateType {
    /**
     * 年-月-日
     * 例如2020-01-01
     */
    YYYY_MM_DD_HYPHEN("yyyy-MM-dd"),
    /**
     * 年-月-日 时:分:秒
     * 例如2020-01-01 20:50:50
     */
    YYYY_MM_DD_HH_MM_SS_HYPHEN("yyyy-MM-dd HH:mm:ss"),
    /**
     * 年-月-日 分:秒
     * 例如2020-01-01 50:50
     */
    YYYY_MM_DD_HH_SS_HYPHEN("yyyy-MM-dd HH:mm"),
    /**
     * 年-月-日 时
     * 例如2020-01-01 20
     */
    YYYY_MM_DD_HH_HYPHEN("yyyy-MM-dd HH"),
    /**
     * 年-月
     * 例如2020-01
     */
    YYYY_MM_HYPHEN("yyyy-MM"),
    /**
     * 年/月/日
     * 例如2020/01/01
     */
    YYYY_MM_DD_SLASH("yyyy/MM/dd"),
    /**
     * 年/月/日 时:分:秒
     * 例如2020/01/01 20:50:50
     */
    YYYY_MM_DD_HH_MM_SS_SLASH("yyyy/MM/dd HH:mm:ss"),
    /**
     * 年/月/日 分:秒
     * 例如2020/01/01 50:50
     */
    YYYY_MM_DD_HH_SS_SLASH("yyyy/MM/dd HH:mm"),
    /**
     * 年/月/日 时
     * 例如2020/01/01 20
     */
    YYYY_MM_DD_HH_SLASH("yyyy/MM/dd HH"),
    /**
     * 年/月
     * 例如2020/01
     */
    YYYY_MM_SLASH("yyyy/MM"),
    /**
     * 年.月.日
     * 例如2020.01.01
     */
    YYYY_MM_DD_DOT("yyyy.MM.dd"),
    /**
     * 年.月.日 时:分:秒
     * 例如2020.01.01 20:50:50
     */
    YYYY_MM_DD_HH_MM_SS_DOT("yyyy.MM.dd HH:mm:ss"),
    /**
     * 年.月.日 分:秒
     * 例如2020.01.01 50:50
     */
    YYYY_MM_DD_HH_SS_DOT("yyyy.MM.dd HH:mm"),
    /**
     * 年.月.日 时
     * 例如2020.01.01 20
     */
    YYYY_MM_DD_HH_DOT("yyyy.MM.dd HH"),
    /**
     * 年.月
     * 例如2020.01
     */
    YYYY_MM_DOT("yyyy.MM"),
    /**
     * 例如2020年01月01日
     */
    YYYY_MM_DD_ZH("yyyy年MM月dd日"),
    /**
     * 例如2020年01月01日 20:50:50
     */
    YYYY_MM_DD_HH_MM_SS_ZH("yyyy年MM月dd日 HH:mm:ss"),
    /**
     * 例如2020年01月01日 50:50
     */
    YYYY_MM_DD_HH_SS_ZH("yyyy年MM月dd日 HH:mm"),
    /**
     * 例如2020年01月01日 20
     */
    YYYY_MM_DD_HH_ZH("yyyy年MM月dd日 HH"),
    /**
     * 例如2020年01日
     */
    YYYY_MM_ZH("yyyy年MM月"),
    /**
     * 获取年份
     * 例如2020
     */
    YYYY("yyyy"),
    /**
     * 获取月份
     * 例如01
     */
    MM("MM"),
    /**
     * 获取天数
     * 例如01
     */
    DD("dd"),
    /**
     * 获取星期几
     * 例如星期一
     */
    E("E"),
    /**
     * 获取时间
     * 例如20:50:50
     */
    HH_MM_SS("HH:mm:ss"),
    /**
     * 获取时间时
     * 例如20
     */
    TIME_HH("HH"),
    /**
     * 获取时间分
     * 例如50
     */
    TIME_MM("mm"),
    /**
     * 获取时间秒
     * 例如50
     */
    TIME_SS("ss"),
    ;
    private final String value;

    public String getValue() {
        return value;
    }

    DateType(String value) {
        this.value = value;
    }
}
