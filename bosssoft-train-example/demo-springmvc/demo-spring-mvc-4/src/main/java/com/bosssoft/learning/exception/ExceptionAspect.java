package com.bosssoft.learning.exception;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Description 异常
 * @Date 2020/6/8 8:36
 * @Author HetFrame
 */
@Aspect
@Component
public class ExceptionAspect {

    @Pointcut("@annotation(com.bosssoft.learning.exception.MyException)")
    public void pointcut() {
        // Do nothing because of 不需要
    }

    @Around(value = "pointcut()")
    public Object err(ProceedingJoinPoint point) {
        Object result = null;
        try {
            result = point.proceed();
        } catch (Throwable throwable) {
            throw new BusinessException(throwable);
        }
        return result;
    }
}
