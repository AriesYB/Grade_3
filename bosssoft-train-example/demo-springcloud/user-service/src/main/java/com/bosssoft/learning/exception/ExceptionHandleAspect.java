package com.bosssoft.learning.exception;

import com.bosssoft.learning.data.convention.CommonResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Description 异常切面 其他层将异常封装成BusinessException并抛出，controller层处理异常并封装至响应体
 * @Date 2020/6/23 15:18
 * @Author HetFrame
 */
@Aspect
@Component
public class ExceptionHandleAspect {
    private static final Logger log = LoggerFactory.getLogger(ExceptionHandleAspect.class);

    @Pointcut("@within(com.bosssoft.learning.exception.ExceptionHandle)")
    public void classPointCut() {
        // 类切入点
    }

    @Pointcut("@annotation(com.bosssoft.learning.exception.ExceptionHandle)")
    public void methodPointCut() {
        // 方法切入点
    }

    /**
     * @param point
     * @Description controller将封装异常信息到响应体，其他异常封装为BusinessException，并记录异常到日志
     * 匹配的切入点是类注解
     * 类注解判断是否是controller的方法.
     * 是：响应体返回
     * 否：记录异常日志，封装异常信息(可能为其它层抛出的封装了的异常，所以不能再修改message和code)并抛出
     * @date 2020/6/23 15:40
     * @return: java.lang.Object
     */
    @Around(value = "classPointCut() && @within(handle)", argNames = "point,handle")
    public Object handleClassException(ProceedingJoinPoint point, ExceptionHandle handle) {
        Object result = null;
        try {
            result = point.proceed();
        } catch (Throwable throwable) {
            if (handle.value()) {
                //controller层封装响应体返回
                BusinessException exception = new BusinessException(throwable);
                return new CommonResponse<>(exception.getCode(), exception.getMessage());
            } else {
                handleException(point, handle, throwable);
            }
        }
        return result;
    }


    /**
     * @param point
     * @param handle
     * @Description 封装方法指定的异常信息
     * @date 2020/6/28 21:23
     * @return: java.lang.Object
     */
    @Around(value = "methodPointCut() && @annotation(handle)", argNames = "point,handle")
    public Object handleMethodException(ProceedingJoinPoint point, ExceptionHandle handle) {
        Object result = null;
        try {
            result = point.proceed();
        } catch (Throwable throwable) {
            handleException(point, handle, throwable);
        }
        return result;
    }


    /**
     * @param point
     * @param handle
     * @param throwable
     * @Description 记录异常日志，并抛出异常
     * @date 2020/6/28 21:37
     * @return: void
     */
    private void handleException(ProceedingJoinPoint point, ExceptionHandle handle, Throwable throwable) {
        //非Controller层记录异常日志
        StringBuilder sb = new StringBuilder();
        sb.append(point.getSignature().getName()).append("()处发生了了异常:").append(throwable).append(throwable.getMessage());
        for (Object info : throwable.getStackTrace()) {
            sb.append("\n").append("at ").append(info);
        }
        log.error("{}", sb);
        //抛出封装了异常信息的异常
        throw new BusinessException(throwable, handle.info());
    }
}
