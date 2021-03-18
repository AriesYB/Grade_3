package com.bosssoft.hr.train.j2se.basic.example.collection;

import com.bosssoft.hr.train.j2se.basic.example.pojo.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description 1
 * @Date 2020/6/2 15:40
 * @Author HetFrame
 */
public class TreeSetImplTest {

    private TreeSet<User> set;

    @Before
    public void setUp() throws Exception {
        set = new TreeSetImpl();
    }

    @After
    public void tearDown() throws Exception {
        set = new TreeSetImpl();
    }

    @Test
    public void add() {
        User user = new User(3, "王五");
        assertTrue(set.add(user));
    }

    @Test
    public void sort() {
        User user = new User(1, "张三");
        User user2 = new User(2, "李四");
        User user3 = new User(3, "王五");
        User users[] = {user, user2, user3};
        User users1[] = {user3, user, user2};
        assertArrayEquals(users, set.sort(users1));

    }


    @Test
    public void contains() {
        User user = new User(3, "王五");
        set.add(user);
        assertTrue(set.contains(user));
    }
}