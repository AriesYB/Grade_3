package com.bosssoft.hr.train.j2se.basic.example.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author HetFrame
 * @Description 线程池
 * @date 2020/5/31 11:15
 */
@Slf4j
public class ThreadPool {
    private static ThreadPool threadPool;
    private int index = 1;
    private final ExecutorService executorService;

    private ThreadPool() {

        executorService = new ThreadPoolExecutor(5, 200,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), new ThreadPoolExecutor.AbortPolicy());
    }

    public static ThreadPool getThreadPool() {
        if (threadPool == null) {
            threadPool = new ThreadPool();
        }
        return threadPool;
    }


    public boolean newThread() {
        executorService.execute(new Task(index));
        index++;
        return true;
    }

    public void shutdown() {
        executorService.shutdown();
        log.info("pool shut down.");
    }
}
