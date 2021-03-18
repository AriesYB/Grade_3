package com.bosssoft.hr.train.j2se.basic.example.thread;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @author HetFrame
 * @Description 线程任务
 * @date 2020/5/31 11:21
 */
@Slf4j
public class Task implements Runnable {

    private final int id;
    private int time;

    public Task(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            ++time;
            log.info("task" + id + " is running...");
        }
        log.info("task:" + id + " is over");
    }
}
