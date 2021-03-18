package com.bosssoft.learning.exception;

/**
 * @Description 业务异常
 * @Date 2020/6/8 8:41
 * @Author HetFrame
 */
public class MybatisBusinessException extends RuntimeException {
    /**
     * @Description
     * @Param 错误代码
     * @Return
     */
    private final int code;
    /**
     * @Description
     * @Param 异常信息
     * @Return
     */
    private final String msg;

    public MybatisBusinessException(Throwable cause) {
        super(cause);
        if (cause instanceof MybatisBusinessException) {
            code = ((MybatisBusinessException) cause).code;
            msg = ((MybatisBusinessException) cause).msg;
        } else {
            code = 100;
            msg = cause.getMessage();
        }
    }

    public MybatisBusinessException(int code, String msg) {
        super("错误代码:" + code + "错误信息:" + msg);
        this.code = code;
        this.msg = msg;
    }

    public MybatisBusinessException(int code, String msg, Throwable cause) {
        super(msg, cause);
        this.code = code;
        this.msg = msg;
    }


    public int code() {
        return code;
    }

    public String msg() {
        return msg;
    }
}
