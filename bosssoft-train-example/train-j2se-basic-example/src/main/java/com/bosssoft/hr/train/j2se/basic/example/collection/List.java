package com.bosssoft.hr.train.j2se.basic.example.collection;

import com.bosssoft.hr.train.j2se.basic.example.pojo.User;

/**
 * @Description List接口
 * @Date 2020/5/30 8:35
 * @Author HetFrame
 */
public interface List<T> {
    /**
     * 加入尾部
     *
     * @param user
     * @return
     */
    boolean append(T user);

    /**
     * 返回指定位置
     *
     * @param index
     * @return
     */
    User get(Integer index);

    /**
     * 中间删除
     *
     * @param position
     * @return
     */
    boolean remove(Integer position);

    /**
     * 按下表遍历 注意这种方式遍历过程不可以删除
     */
    void listByIndex();

    /**
     * 按迭代器遍历
     */
    void listByIterator();

    /**
     * 列表数组转换
     *
     * @return
     */
    User[] toArray();

    /**
     * 列表排序演示
     */
    void sort();
}
