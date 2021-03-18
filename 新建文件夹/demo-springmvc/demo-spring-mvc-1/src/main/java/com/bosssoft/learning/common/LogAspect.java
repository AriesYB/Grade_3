package com.bosssoft.learning.common;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
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
        // Do nothing because of 不需要
    }

    /**
     * @Description 日志方法 Around表示在切入点方法执行前后执行日志方法 joinPoint用于获取切入点的方法等参数
     * @Param []
     * @Return java.lang.Object
     */
    @Around("pointcut()")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
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
        if (((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()) != null) {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            sb.append("请求者IP:").append(request.getRemoteAddr()).append("\n");
            sb.append("参数内容:").append(request.getQueryString()).append("\n");
        }

        Object result = new Object();
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            log.error(throwable.getMessage());
        }
        long endTime = System.currentTimeMillis();
        sb.append("请求耗时:").append((endTime - startTime) / (double) 1000).append("s\n");

        sb.append("应答内容:").append(result.toString()).append("\n");

        log.info("---mylog----\n" + sb.toString());
        return result;
    }

}
