package com.bosssoft.hr.train.j2se.basic.example.collection;

import com.bosssoft.hr.train.j2se.basic.example.pojo.User;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Description TreeSet排序
 * @Date 2020/5/30 15:43
 * @Author HetFrame
 */
public class TreeSetExampleImpl implements TreeSetExmaple<User> {
    private Set<User> set = new TreeSet<>((o1, o2) -> o1.getId() - o2.getId());

    @Override
    public User[] sort(User[] arry) {
        if (null != arry && arry.length > 0) {
            // 因为比较器的存在加入的时候将按顺序排列
            set.addAll(Arrays.asList(arry));
            return set.toArray(new User[0]);
        } else {
            return new User[]{};
        }
    }
}
