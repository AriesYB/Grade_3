package com.bosssoft.hr.train.j2se.basic.example.collection;

import com.bosssoft.hr.train.j2se.basic.example.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

@Slf4j
public class LinkedListExampleImplTest {

    private LinkedList<User> list;

    @Before
    public void setUp() throws Exception {
        list = new LinkedListImpl();
    }

    @After
    public void tearDown() throws Exception {
        list = new LinkedListImpl();
    }

    @Test
    public void append() {
        User user = new User(1, "张三");
        assertTrue(list.append(user));
    }

    @Test
    public void get() {
        User user = new User(1, "张三");
        list.append(user);
        assertEquals(user, list.get(0));
    }

    @Test
    public void insert() {
        User user = new User(1, "张三");
        User user2 = new User(2, "李四");
        User user3 = new User(3, "王五");
        list.append(user);
        list.append(user2);
        assertEquals(user2, list.get(1));
        list.insert(1, user3);
        assertEquals(user2, list.get(2));
        assertEquals(user3, list.get(1));
    }

    @Test
    public void remove() {
        User user = new User(1, "张三");
        User user2 = new User(2, "李四");
        list.append(user);
        list.append(user2);
        assertEquals(user2, list.get(1));
        assertTrue(list.remove(0));
        assertEquals(user2, list.get(0));
    }

    @Test
    public void listByIndex() {
        User user = new User(1, "张三");
        User user2 = new User(2, "李四");
        User user3 = new User(3, "王五");
        list.append(user);
        list.append(user2);
        list.append(user3);
        list.listByIndex();
        assertNotNull(list);
    }

    @Test
    public void listByIterator() {
        User user = new User(1, "张三");
        User user2 = new User(2, "李四");
        User user3 = new User(3, "王五");
        list.append(user);
        list.append(user2);
        list.append(user3);
        list.listByIterator();
        assertNotNull(list);
    }

    @Test
    public void toArray() {
        User user = new User(1, "张三");
        User user2 = new User(2, "李四");
        User user3 = new User(3, "王五");
        list.append(user);
        list.append(user2);
        list.append(user3);
        User[] users = {user, user2, user3};
        assertArrayEquals(users, list.toArray());
    }

    @Test
    public void sort() {
        User user = new User(1, "张三");
        User user2 = new User(2, "李四");
        User user3 = new User(3, "王五");
        list.append(user3);
        list.append(user);
        list.append(user2);
        list.listByIndex();
        log.info("-----------排序后------------");
        list.sort();
        list.listByIndex();
        assertNotNull(list);
    }

    @Test
    public void sort2() {
        User user = new User(1, "张三");
        User user2 = new User(2, "李四");
        User user3 = new User(3, "王五");
        list.append(user3);
        list.append(user);
        list.append(user2);
        list.listByIndex();
        log.info("-----------排序后------------");
        LinkedListImpl list1 = (LinkedListImpl) list;
        list1.sort2();
        list.listByIndex();
        assertNotNull(list);
    }

    @Test
    public void addFirst() {
        User user = new User(1, "张三");
        User user2 = new User(2, "李四");
        User user3 = new User(3, "王五");
        list.append(user);
        list.append(user2);
        assertEquals(user, list.get(0));
        list.addFirst(user3);
        assertEquals(user3, list.get(0));
    }

    @Test
    public void offer() {
        User user = new User(1, "张三");
        User user2 = new User(2, "李四");
        User user3 = new User(3, "王五");
        list.append(user);
        list.append(user2);
        list.offer(user3);
        assertEquals(user3, list.get(2));
    }

    @Test
    public void sychronizedVisit() {
        User user = new User(1, "张三");
        User user2 = new User(2, "李四");
        User user3 = new User(3, "王五");
        list.append(user);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                list.sychronizedVisit(user2);
            }
        };
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                list.sychronizedVisit(user3);
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread thread1 = new Thread(runnable1);
        thread1.start();
        runnable.run();
        runnable1.run();
        assertEquals(user2, list.get(1));
        assertEquals(user3, list.get(2));
    }

    @Test
    public void push() {
        User user = new User(1, "张三");
        User user2 = new User(2, "李四");
        User user3 = new User(3, "王五");
        list.append(user);
        list.append(user2);
        list.push(user3);
        assertEquals(user3, list.get(0));
    }

    @Test
    public void pop() {
        User user = new User(1, "张三");
        User user2 = new User(2, "李四");
        User user3 = new User(3, "王五");
        list.append(user);
        list.append(user2);
        list.push(user3);
        assertEquals(user3, list.pop());
    }
}