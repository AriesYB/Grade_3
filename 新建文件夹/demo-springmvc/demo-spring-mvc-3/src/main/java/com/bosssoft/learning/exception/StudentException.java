package com.bosssoft.learning.exception;

/**
 * @Description 学生异常类 回滚异常
 * @Date 2020/6/6 21:31
 * @Author HetFrame
 */
public class StudentException extends Exception {

    public StudentException() {
        super();
    }

    public StudentException(String message) {
        super(message);
    }
}
