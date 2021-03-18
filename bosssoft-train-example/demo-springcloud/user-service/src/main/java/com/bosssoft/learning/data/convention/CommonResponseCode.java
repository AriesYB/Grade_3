package com.bosssoft.learning.data.convention;

/**
 * @Description 响应时代码和信息
 * @Date 2020/6/24 10:08
 * @Author HetFrame
 */
public enum CommonResponseCode {


    /**
     * 成功响应
     */
    SUCCESS("200", "success"),
    /**
     * 登录成功
     */
    LOGIN_SUCCESS("201", "登录成功"),
    /**
     * 登录失败
     */
    LOGIN_FAILED("202", "登录失败"),
    /**
     * token无效
     */
    TOKEN_INVALID("401", "token无效"),
    /**
     * token过期
     */
    TOKEN_EXPIRED("402", "token过期"),
    /**
     * 页面未找到
     */
    NOT_FOUND("404", "页面未找到"),
    /**
     * 服务不可用
     */
    SERVICE_UNAVAILABLE("503", "服务不可用");

    /**
     * 响应代码
     */
    private final String code;
    /**
     * 响应信息
     */
    private final String message;

    CommonResponseCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
