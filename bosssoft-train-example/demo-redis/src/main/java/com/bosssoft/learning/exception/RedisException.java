package com.bosssoft.learning.exception;

/**
 * @Description redis异常
 * @Date 2020/6/29 10:35
 * @Author HetFrame
 */
public class RedisException extends RuntimeException{
    private final String code;

    public String getCode() {
        return code;
    }

    public RedisException(String code) {
        super();
        this.code = code;
    }

    public RedisException(String message, String code) {
        super(message);
        this.code = code;
    }

    public RedisException(String message, Throwable cause, String code) {
        super(message, cause);
        this.code = code;
    }

    public RedisException(Throwable cause, String code) {
        super(cause);
        this.code = code;
    }

    public RedisException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String code) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }
}
