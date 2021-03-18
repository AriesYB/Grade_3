package com.bosssoft.hr.train.j2se.basic.example.proxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description JDK proxy
 * @Date 2020/6/5 9:44
 * @Author HetFrame
 */
@Slf4j
public class JDKProxy implements InvocationHandler {

    private Object object;

    public Object newInstance(Object object) {
        this.object = object;
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("调用方法前");
        method.invoke(object,args);
        log.info("调用方法后");
        return null;
    }
}
