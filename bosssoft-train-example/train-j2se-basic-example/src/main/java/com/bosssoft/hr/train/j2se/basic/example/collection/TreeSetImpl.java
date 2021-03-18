package com.bosssoft.hr.train.j2se.basic.example.collection;

import com.bosssoft.hr.train.j2se.basic.example.pojo.User;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;

/**
 * @Description TreeSet实现
 * @Date 2020/5/30 16:05
 * @Author HetFrame
 */

public class TreeSetImpl implements TreeSet<User> {
    private Set<User> set = new java.util.TreeSet<>(Comparator.comparingInt(User::getId));

    @Override
    public User[] sort(User[] arry) {
        if (null != arry && arry.length > 0) {
            set.addAll(Arrays.asList(arry));
            return set.toArray(new User[0]);
        } else {
            return new User[]{};
        }
    }

    @Override
    public boolean add(User user) {
        return (null != user) && set.add(user);
    }

    @Override
    public boolean contains(Object o) {
        return (null != o) && set.contains(o);
    }
}
