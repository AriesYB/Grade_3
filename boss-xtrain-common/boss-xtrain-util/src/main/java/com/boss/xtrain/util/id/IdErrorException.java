package com.boss.xtrain.util.id;

/**
 * @Description 生成ID时错误
 * @Date 2020/7/6 9:43
 * @Author HetFrame
 */
public class IdErrorException extends RuntimeException {
    public IdErrorException() {
    }

    public IdErrorException(String message) {
        super(message);
    }

    public IdErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public IdErrorException(Throwable cause) {
        super(cause);
    }

    public IdErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
