package com.bosssoft.hr.train.j2se.basic.example.collection;

import com.bosssoft.hr.train.j2se.basic.example.pojo.User;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * @Description ArrayList实现
 * @Date 2020/5/30 8:31
 * @Author HetFrame
 */

@Slf4j
public class ArrayListImpl implements ArrayList<User> {
    /**
     * =============================》ArrayList
     * arrayList对象
     */
    private final List<User> users = new java.util.ArrayList<>();

    /**
     * 这里开始 关于 arraylist的主要方法测试
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
            log.info(Constraint.LOG_TAG + users.get(i));
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
        return users.toArray(new User[0]);
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

        users.sort(Comparator.comparingInt(User::getId));
    }

}
