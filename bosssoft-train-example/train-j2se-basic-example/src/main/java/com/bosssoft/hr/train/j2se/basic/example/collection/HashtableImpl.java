package com.bosssoft.hr.train.j2se.basic.example.collection;

import com.bosssoft.hr.train.j2se.basic.example.pojo.Resource;
import com.bosssoft.hr.train.j2se.basic.example.pojo.Role;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Description HashTable实现
 * @Date 2020/5/30 14:40
 * @Author HetFrame
 */

@Slf4j
public class HashtableImpl implements Hashtable<Role, Resource> {
    /**
     * 通过id进行排序
     */
    private Map<Role, Resource> map = new HashMap<>();

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
        Set<Map.Entry<Role, Resource>> set = map.entrySet();
        for (Map.Entry<Role, Resource> entry : set) {
            log.info(Constraint.LOG_TAG + entry.getKey() + "----" + entry.getValue());
        }
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
