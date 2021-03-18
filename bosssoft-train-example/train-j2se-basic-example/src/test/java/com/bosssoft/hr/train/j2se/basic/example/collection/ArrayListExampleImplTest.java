package com.bosssoft.hr.train.j2se.basic.example.collection;

import com.bosssoft.hr.train.j2se.basic.example.pojo.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayListExampleImplTest {
    private ArrayList<User> list;

    @Before
    public void setUp() throws Exception {
        list = new ArrayListImpl();
    }

    @After
    public void tearDown() throws Exception {
        list = new ArrayListImpl();
    }

    @Test
    public void append() {
        User user =  new User(1,"张三");
        assertTrue(list.append(user));
    }

    @Test
    public void get() {
        User user =  new User(1,"张三");
        list.append(user);
        assertEquals(user,list.get(0));
    }

    @Test
    public void insert() {
        User user =  new User(1,"张三");
        User user2 =  new User(2,"李四");
        User user3 =  new User(3,"王五");
        list.append(user);
        list.append(user2);
        assertEquals(user2,list.get(1));
        list.insert(1,user3);
        assertEquals(user2,list.get(2));
        assertEquals(user3,list.get(1));
    }

    @Test
    public void remove() {
        User user =  new User(1,"张三");
        User user2 =  new User(2,"李四");
        list.append(user);
        list.append(user2);
        assertEquals(user2,list.get(1));
        assertTrue(list.remove(0));
        assertEquals(user2,list.get(0));
    }

    @Test
    public void listByIndex() {
        User user =  new User(1,"张三");
        User user2 =  new User(2,"李四");
        User user3 =  new User(3,"王五");
        list.append(user);
        list.append(user2);
        list.append(user3);
        list.listByIndex();
        assertNotNull(user);
    }

    @Test
    public void listByIterator() {
        User user =  new User(1,"张三");
        User user2 =  new User(2,"李四");
        User user3 =  new User(3,"王五");
        list.append(user);
        list.append(user2);
        list.append(user3);
        list.listByIterator();
        assertNotNull(user);
    }

    @Test
    public void toArray() {
        User user =  new User(1,"张三");
        User user2 =  new User(2,"李四");
        User user3 =  new User(3,"王五");
        list.append(user);
        list.append(user2);
        list.append(user3);
        User [] users = {user,user2,user3};
        assertArrayEquals(users,list.toArray());
    }

    @Test
    public void sort() {
        User user =  new User(1,"张三");
        User user2 =  new User(2,"李四");
        User user3 =  new User(3,"王五");
        list.append(user3);
        list.append(user);
        list.append(user2);
        list.listByIndex();
        list.sort();
        list.listByIndex();
        assertNotNull(user);
    }
}