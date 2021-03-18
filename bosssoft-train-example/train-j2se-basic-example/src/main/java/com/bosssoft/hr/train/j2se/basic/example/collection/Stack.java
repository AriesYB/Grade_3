package com.bosssoft.hr.train.j2se.basic.example.collection;

/**
 * @Description 栈
 * @Date 2020/5/30 15:15
 * @Author HetFrame
 */

public interface Stack<T> {
    boolean empty();
    T peek();
    T pop();
    T push(T t);
    int search(Object o);
}
