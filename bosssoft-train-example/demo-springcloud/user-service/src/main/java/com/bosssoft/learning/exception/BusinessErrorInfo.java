package com.bosssoft.learning.exception;

/**
 * @Description 异常类型枚举类
 * @Date 2020/6/23 14:22
 * @Author HetFrame
 */
public enum BusinessErrorInfo {

    /**
     * 验证账号密码出现异常
     */
    FAIL_TO_VALIDATE_USER("10000", "验证用户失败"),
    /**
     * 保存用户出现异常
     */
    FAIL_TO_SAVE_USER("10001", "保存用户失败"),
    /**
     * 更新用户出现异常
     */
    FAIL_TO_UPDATE_USER("10002", "更新用户失败"),
    /**
     * 删除用户出现异常
     */
    FAIL_TO_DELETE_USER("10003", "删除用户失败"),
    /**
     * 查询用户的异常
     */
    FAIL_TO_QUERY_USER("10004","查询用户失败"),
    /**
     * 未定义的异常
     */
    UNDEFINED("00000", "未定义");


    /**
     * 错误代码
     */
    private final String code;
    /**
     * 异常信息
     */
    private final String message;

    BusinessErrorInfo(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * @param code
     * @Description 根据code返回异常信息
     * @return: java.lang.String
     */
    public static String msg(String code) {
        for (BusinessErrorInfo businessErrorInfo : BusinessErrorInfo.values()) {
            if (businessErrorInfo.getCode().equals(code)) {
                return businessErrorInfo.message;
            }
        }
        return UNDEFINED.message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
