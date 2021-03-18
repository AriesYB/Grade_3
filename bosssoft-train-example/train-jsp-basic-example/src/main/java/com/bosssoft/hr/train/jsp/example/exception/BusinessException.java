package com.bosssoft.hr.train.jsp.example.exception;

/**
 * @description: service类将通过try catch 跑出这种异常
 * @author: Administrator
 * @create: 2020-05-30 10:32
 * @since
 **/
public class BusinessException extends RuntimeException {
    private final String code;

    public BusinessException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
