package com.bosssoft.hr.train.j2se.basic.example.thread;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author HetFrame
 * @Description TODO
 * @date 2020/5/31 11:36
 */
@Slf4j
public class ThreadPoolTest {

    @Test
    public void newThread() {
        ThreadPool.getThreadPool().newThread();
        ThreadPool.getThreadPool().newThread();
        ThreadPool.getThreadPool().newThread();
        ThreadPool.getThreadPool().newThread();
        assertTrue(ThreadPool.getThreadPool().newThread());
        ThreadPool.getThreadPool().shutdown();
    }
}