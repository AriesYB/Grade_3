package com.bosssoft.learning.exception;

/**
 * @Description 异常类
 * @Date 2020/6/23 14:21
 * @Author HetFrame
 */
public class BusinessException extends RuntimeException {
    /**
     * 异常码
     */
    private final String code;

    public String getCode() {
        return code;
    }

    /**
     * @param code
     * @param message
     * @Description 使用code和message创建异常
     * @return: null
     */
    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * @param cause
     * @Description 使用Throwable创建异常
     * @date 2020/6/28 20:34
     * @return: null
     */
    public BusinessException(Throwable cause) {
        super(cause);
        if (cause instanceof BusinessException) {
            this.code = ((BusinessException) cause).code;
        } else {
            this.code = BusinessErrorInfo.UNDEFINED.getCode();
        }
    }

    /**
     * @param businessErrorCode
     * @Description 使用异常信息枚举
     * @date 2020/6/28 20:34
     * @return: null
     */
    public BusinessException(BusinessErrorInfo businessErrorCode) {
        super(businessErrorCode.getMessage());
        this.code = businessErrorCode.getCode();
    }

    /**
     * @param cause
     * @param code
     * @param message
     * @Description 使用Throwable、code、message创建异常
     * @date 2020/6/28 20:34
     * @return: null
     */
    public BusinessException(Throwable cause, String code, String message) {
        super(message, cause);
        this.code = code;
    }

    /**
     * @param cause
     * @param businessErrorCode
     * @Description 使用Throwable、异常信息枚举创建异常
     * @date 2020/6/28 20:35
     * @return: null
     */
    public BusinessException(Throwable cause, BusinessErrorInfo businessErrorCode) {
        super(businessErrorCode.getMessage(), cause);
        this.code = businessErrorCode.getCode();
    }

}
