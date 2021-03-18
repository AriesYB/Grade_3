package com.bosssoft.hr.train.j2se.basic.example.collection;

import com.bosssoft.hr.train.j2se.basic.example.pojo.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description 队列
 * @Date 2020/6/2 15:47
 * @Author HetFrame
 */
public class QueueImplTest {

    private Queue<User> queue;

    @Before
    public void setUp() throws Exception {
        queue = new QueueImpl();
    }

    @After
    public void tearDown() throws Exception {
        queue = new QueueImpl();
    }

    @Test
    public void offer() {
        User user = new User(1, "张三");
        assertTrue(queue.offer(user));
    }

    @Test
    public void element() {
        User user = new User(1, "张三");
        User user2 = new User(2, "李四");
        User user3 = new User(3, "王五");
        queue.offer(user);
        queue.offer(user2);
        queue.offer(user3);
        assertEquals(user,queue.element());

    }


    @Test
    public void peek() {
        User user = new User(1, "张三");
        User user2 = new User(2, "李四");
        User user3 = new User(3, "王五");
        queue.offer(user);
        queue.offer(user2);
        queue.offer(user3);
        assertEquals(user,queue.peek());
    }

    @Test
    public void poll() {
        User user = new User(1, "张三");
        User user2 = new User(2, "李四");
        User user3 = new User(3, "王五");
        queue.offer(user);
        queue.offer(user2);
        queue.offer(user3);
        assertEquals(user,queue.poll());
        assertEquals(user2,queue.poll());
    }
}