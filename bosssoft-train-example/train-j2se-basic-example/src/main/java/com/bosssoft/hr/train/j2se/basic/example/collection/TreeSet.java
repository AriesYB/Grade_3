package com.bosssoft.hr.train.j2se.basic.example.collection;

/**
 * @Description TreeSet
 * @Date 2020/5/30 15:33
 * @Author HetFrame
 */

public interface TreeSet<T> {
    /**
     * 测试实现对数据排序
     *
     * @param arry
     * @return 已经排序的数组
     */
    T[] sort(T[] arry);

    /**
     *
     * @param t
     * @return
     */
    boolean add(T t);

    /**
     *
     * @param o
     * @return
     */
    boolean contains(Object o);
}
