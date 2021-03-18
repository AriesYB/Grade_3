package com.bosssoft.learning.common;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description 切面日志
 * @Date 2020/6/7 10:18
 * @Author HetFrame
 */

@Slf4j
@Aspect
@Component
public class LogAspect {

    /**
     * @Description 切入点 所有返回值、所有类、所有参数的方法 这里切入controller中的方法
     * @Param []
     * @Return void
     */
    @Pointcut("@annotation(com.bosssoft.learning.common.MyLogApi)")
    private void pointcut() {
        /*指定切入点*/
    }

    /**
     * @Description 日志方法 Around表示在切入点方法执行前后执行日志方法 joinPoint用于获取切入点的方法等参数
     * @Param []
     * @Return java.lang.Object
     */
    @Around("pointcut()")
    public Object log(ProceedingJoinPoint joinPoint) {
        //获取方法名
        String methodName = joinPoint.getSignature().getName();
        //获取方法参数
        Method[] methods = joinPoint.getTarget().getClass().getMethods();
        String operate = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                MyLogApi myLog = method.getAnnotation(MyLogApi.class);
                operate = myLog.action();
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("操作:").append(operate).append("\n");
        sb.append("方法名:").append(methodName).append("\n");
        long startTime = System.currentTimeMillis();
        sb.append("请求时间:").append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())).append("\n");
        Object result = new Object();
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            log.error(throwable.getMessage());
        }
        long endTime = System.currentTimeMillis();
        sb.append("请求耗时:").append((endTime - startTime) / (double) 1000).append("s\n");
        sb.append("应答内容:").append(result.toString()).append("\n");
        log.info("\n{}" ,sb.toString());
        return result;
    }

}
