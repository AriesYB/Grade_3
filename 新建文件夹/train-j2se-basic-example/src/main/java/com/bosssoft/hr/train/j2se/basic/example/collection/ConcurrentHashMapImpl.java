package com.bosssoft.hr.train.j2se.basic.example.collection;

import com.bosssoft.hr.train.j2se.basic.example.pojo.Resource;
import com.bosssoft.hr.train.j2se.basic.example.pojo.Role;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.Set;

/**
 * @Description ConcurrentHashMap实现
 * @Date 2020/5/30 8:32
 * @Author HetFrame
 */

@Slf4j
public class ConcurrentHashMapImpl implements ConcurrentHashMap<Role, Resource> {
    /**
     * 定义 ConcurrentHashMap对象用于测试
     */
    private java.util.Map<Role, Resource> map = new java.util.concurrent.ConcurrentHashMap<>();

    /**
     * 然后该方法不用加 synchronized 也是线程安全，但是操作并不因为锁定，这个就是
     * 该类对hashtable的改进
     *
     * @param key   map的键
     * @param value 值
     * @return
     */
    @Override
    public Resource put(Role key, Resource value) {
        return map.put(key, value);
    }

    @Override
    public Resource remove(Role key) {
        // 因为 重写了 Role 的 equal 和 hashcode 所以保证根据id删除
        return map.remove(key);
    }

    @Override
    public boolean containsKey(Role key) {
        return map.containsKey(key);
    }

    @Override
    public void visitByEntryset() {
        Set<java.util.Map.Entry<Role, Resource>> set = map.entrySet();
        for (java.util.Map.Entry<Role, Resource> entry : set) {
            log.info(Constraint.LOG_TAG + entry.getKey() + "####" + entry.getValue());
        }
    }

    /**
     * 请比较 传统的for遍历和 lambda 的 forEach 代码简洁效率高，
     * 请在JDK1.8以上的代码中执行
     */
    public void visitByEntrysetLambda() {
        Set<java.util.Map.Entry<Role, Resource>> set = map.entrySet();
        set.forEach(entry -> log.info(Constraint.LOG_TAG + entry.getKey() + "####" + entry.getValue()));
    }


    @Override
    public void visitByKeyset() {
        if (null != map) {
            Set<Role> set = map.keySet();
            for (Role role : set) {
                log.info(Constraint.LOG_TAG + role);
                log.info(Constraint.LOG_TAG + map.get(role));
            }
        }
    }

    @Override
    public void visitByValues() {
        Collection<Resource> collection = map.values();
        for (Resource resource : collection) {
            log.info(Constraint.LOG_TAG + resource);
        }
    }
}
