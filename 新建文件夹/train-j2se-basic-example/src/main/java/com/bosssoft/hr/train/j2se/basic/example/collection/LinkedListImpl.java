package com.bosssoft.hr.train.j2se.basic.example.collection;

import com.bosssoft.hr.train.j2se.basic.example.pojo.User;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/**
 * @Description 链表实现
 * @Date 2020/5/30 14:39
 * @Author HetFrame
 */

@Slf4j
public class LinkedListImpl implements LinkedList<User> {
    public static final String LOG_TAG = "j2se-basic-example-log:";
    /**
     * =============================》LinkedList
     * LinkedList对象
     */
    private java.util.LinkedList<User> users = new java.util.LinkedList<>();

    /**
     * 这里开始 关于 LinkedList的主要方法测试
     *
     * @param node
     * @return
     */
    @Override
    public boolean append(User node) {
        return users.add(node);
    }

    @Override
    public User get(Integer index) {
        return index >= 0 && index < users.size() ? users.get(index) : null;
    }

    @Override
    public boolean insert(Integer position, User user) {
        if (position >= 0 && position < users.size()) {
            users.add(position, user);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean remove(Integer position) {
        return (position >= 0 && position < users.size()) && users.remove(position.intValue()) != null;
    }

    @Override
    public void listByIndex() {
        int size = users.size();
        for (int i = 0; i < size; i++) {
            log.info(LOG_TAG + users.get(i));
        }
    }

    @Override
    public void listByIterator() {
        Iterator<User> iterator = users.iterator();
        User user;
        while (iterator.hasNext()) {
            user = iterator.next();
            log.info(Constraint.LOG_TAG + user);
        }
    }

    @Override
    public User[] toArray() {
        return users != null ? users.toArray(new User[0]) : null;
    }

    /**
     * sonarlint 将会建议改进这种写法
     */
    @Override
    public void sort() {

        /**
         *  这里 创建了一个匿名类实现了接口 Comparator
         *  也可以通过让 User 实现 Comparable接口实现但是这样做就污染了User类了
         */

        users.sort((o1, o2) -> o1.getId() - o2.getId());
    }


    public void sort2() {

        /**
         * what is lambda
         Syntax and Structure
         So, standard syntax of lambda is as follows:

         () -> some expression
         Or
         (arguments) -> { body just like function }
         * why lambda
         * simple and efficiency
         */

        users.sort((Comparator.comparingInt(User::getId)));
    }

    /**
     * 队列 方法测试 ============================>队列方法测试
     *
     * @param node
     */
    @Override
    public void addFirst(User node) {
        users.addFirst(node);
    }

    @Override
    public boolean offer(User node) {

        return users.offer(node);
    }

    @Override
    public void sychronizedVisit(User node) {
        /**
         * 注意采用这种方法实现线程安全
         */
        Collections.synchronizedCollection(users).add(node);
    }

    @Override
    public void push(User node) {
        users.push(node);
    }

    @Override
    public User pop() {
        return users.pop();
    }
}
