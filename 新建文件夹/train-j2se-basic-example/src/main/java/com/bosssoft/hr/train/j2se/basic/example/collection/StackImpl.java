package com.bosssoft.hr.train.j2se.basic.example.collection;

import com.bosssoft.hr.train.j2se.basic.example.pojo.User;

/**
 * @Description 栈实现
 * @Date 2020/5/30 15:15
 * @Author HetFrame
 */

public class StackImpl implements Stack<User> {
    private final java.util.Stack<User> users = new java.util.Stack<>();
    @Override
    public boolean empty() {
        return users.empty();
    }

    @Override
    public User peek() {
        return (!users.empty()) ? users.peek() : null;
    }

    @Override
    public User pop() {
        return (!users.empty()) ? users.pop() : null;
    }

    @Override
    public User push(User user) {
        return (null != user) ? users.push(user) : null;
    }

    @Override
    public int search(Object o) {
        return (null != o) ? users.search(o) : -1;
    }
}
