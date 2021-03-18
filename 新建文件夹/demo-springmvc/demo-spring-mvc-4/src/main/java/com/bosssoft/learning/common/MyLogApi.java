package com.bosssoft.learning.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description 日志注解
 * @Date 2020/6/7 10:17
 * @Author HetFrame
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface MyLogApi {

    public String action() default "";

    public String desc() default "";

}
