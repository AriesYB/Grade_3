package com.bosssoft.learning.exception;

import java.lang.annotation.*;

/**
 * @Description 处理异常注解
 * @Date 2020/6/23 15:25
 * @Author HetFrame
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExceptionHandle {
    /**
     * 是否为Controller层的,默认为false，当为true时，会处理异常，将异常信息封装进CommonResponse，反之就封装异常并抛出.
     *
     * @return: boolean
     */
    public boolean value() default false;

    /**
     * 绑定异常信息
     */
    public BusinessErrorInfo info() default BusinessErrorInfo.UNDEFINED;
}
