package com.boss.xtrain.util.string;

import org.apache.commons.lang3.StringUtils;

/**
 * @Description 整合apache StringUtils字符串转换工具类
 * @Date 2020/7/1 9:22
 * @Author HetFrame
 */
public class StringUtil {
    private static StringUtil instance;

    private StringUtil() {
        // 私有无参构造器
    }

    /**
     * @Description 懒汉模式获取实例, 线程安全, 节约内存
     * @date 2020/7/1 10:17
     * @return: StringUtil
     */
    public static StringUtil getInstance() {
        if (instance == null) {
            synchronized (StringUtil.class) {
                if (instance == null) {
                    instance = new StringUtil();
                }
            }
        }
        return instance;
    }


    /**
     * @param str 字符串
     * @Description 判断字符串是否为""或者为null
     * @date 2020/7/1 9:55
     * @return: boolean
     */
    public boolean isEmpty(String str) {
        return StringUtils.isEmpty(str);
    }

    /**
     * @param str 字符串
     * @Description 判断字符串是否不为""且不为null
     * @date 2020/7/1 9:55
     * @return: boolean
     */
    public boolean isNotEmpty(String str) {
        return StringUtils.isNotEmpty(str);
    }

    /**
     * @param str 字符串
     * @Description 判断字符串是否为""
     * @date 2020/7/1 9:59
     * @return: boolean
     */
    public boolean isBlank(String str) {
        return StringUtils.isBlank(str);
    }

    /**
     * @param str 字符串
     * @Description 判断字符串是否不为""
     * @date 2020/7/1 10:01
     * @return: boolean
     */
    public boolean isNotBlank(String str) {
        return StringUtils.isNotBlank(str);
    }

    /**
     * @param str 字符串
     * @Description 去除字符串首位的空格, 若剩下空串则返回空串;若字符串为null则返回null
     * @date 2020/7/1 10:02
     * @return: java.lang.String
     */
    public String trim(String str) {
        return StringUtils.trim(str);
    }

    /**
     * @param str 字符串
     * @Description 去除字符串首位的空格，若剩下空串则返回null;若字符串为null则返回null
     * @date 2020/7/1 10:04
     * @return: java.lang.String
     */
    public String trimToNull(String str) {
        return StringUtils.trimToEmpty(str);
    }

    /**
     * @param str 字符串
     * @Description 去除字符串首位的空格，若剩下空串则返回空串;若字符串为null,则返回空串
     * @date 2020/7/1 10:07
     * @return: java.lang.String
     */
    public String trimToEmpty(String str) {
        return StringUtils.trimToEmpty(str);
    }

}
