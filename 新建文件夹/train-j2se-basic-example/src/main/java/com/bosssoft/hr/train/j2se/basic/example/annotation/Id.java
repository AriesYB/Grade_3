package com.bosssoft.hr.train.j2se.basic.example.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description: 注解在字段上 对应数据表ID
 * @author: Administrator
 * @create: 2020-05-28 22:37
 * @since
 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Id {
    String value();
}
