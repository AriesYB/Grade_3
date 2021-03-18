package com.bosssoft.learning.common;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description test
 * @Date 2020/6/10 10:56
 * @Author HetFrame
 */
@Slf4j
public class CallProcedureTest {

    @Test
    public void doCall() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CallProcedure callProcedure = context.getBean(CallProcedure.class);
        callProcedure.doCall();
        Assert.assertNotNull(callProcedure);
    }
}