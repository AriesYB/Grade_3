package com.bosssoft.hr.train.j2se.basic.example.collection;

/**
 * @Description 队列接口
 * @Date 2020/5/30 14:39
 * @Author HetFrame
 */

public interface Queue<T> {
    T element();

    boolean offer(T t);

    T peek();

    T poll();
}
