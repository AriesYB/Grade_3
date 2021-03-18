package com.bosssoft.hr.train.j2se.basic.example.collection;

/**
 * @Description ArrayList
 * @Date 2020/5/30 8:25
 * @Author HetFrame
 */
public interface ArrayList<T> extends List<T> {
    /**
     * @param position
     * @param node
     * @return
     */
    boolean insert(Integer position, T node);

}
