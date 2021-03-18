package com.bosssoft.hr.train.j2se.basic.example.collection;

import com.bosssoft.hr.train.j2se.basic.example.pojo.Resource;
import com.bosssoft.hr.train.j2se.basic.example.pojo.Role;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Date 2020/6/2 15:12
 * @Author HetFrame
 */
public class HashtableImplTest {

    private Hashtable<Role, Resource> map;

    @Before
    public void setUp() throws Exception {
        map = new HashtableImpl();
    }

    @After
    public void tearDown() throws Exception {
        map = new HashtableImpl();
    }

    @Test
    public void put() {
        Role role = new Role(1, "张三");
        Resource resource = new Resource(1, "按钮一");
        map.put(role, resource);
        assertTrue(map.containsKey(role));
    }

    @Test
    public void remove() {
        Role role = new Role(1, "张三");
        Resource resource = new Resource(1, "按钮一");
        map.put(role, resource);
        assertEquals(resource, map.remove(role));
    }

    @Test
    public void containsKey() {
        Role role = new Role(1, "张三");
        Resource resource = new Resource(1, "按钮一");
        assertFalse(map.containsKey(role));
        map.put(role, resource);
        assertTrue(map.containsKey(role));
    }

    @Test
    public void visitByEntryset() {
        Role role = new Role(1, "张三");
        Resource resource = new Resource(1, "按钮一");
        map.put(role, resource);
        map.visitByEntryset();
        assertNotNull(map);
    }

    @Test
    public void visitByKeyset() {
        Role role = new Role(1, "张三");
        Resource resource = new Resource(1, "按钮一");
        map.put(role, resource);
        map.visitByKeyset();
        assertNotNull(map);
    }

    @Test
    public void visitByValues() {
        Role role = new Role(1, "张三");
        Resource resource = new Resource(1, "按钮一");
        map.put(role, resource);
        map.visitByValues();
        assertNotNull(map);
    }
}