package com.bosssoft.hr.train.j2se.basic.example.collection;

import com.bosssoft.hr.train.j2se.basic.example.pojo.User;

/**
 * @Description 队列实现
 * @Date 2020/5/30 14:58
 * @Author HetFrame
 */

public class QueueImpl implements Queue<User> {
    private java.util.LinkedList<User> users = new java.util.LinkedList<>();

    @Override
    public User element() {
        if (!users.isEmpty()) {
            return users.element();
        } else {
            return null;
        }
    }

    @Override
    public boolean offer(User user) {
        return users.offer(user);
    }

    @Override
    public User peek() {
        return users.peek();
    }

    @Override
    public User poll() {
        return users.poll();
    }
}
