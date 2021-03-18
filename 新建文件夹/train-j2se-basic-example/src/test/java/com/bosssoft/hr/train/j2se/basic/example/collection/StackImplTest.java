package com.bosssoft.hr.train.j2se.basic.example.collection;

import com.bosssoft.hr.train.j2se.basic.example.pojo.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description Stack
 * @Date 2020/6/2 15:52
 * @Author HetFrame
 */
public class StackImplTest {

    private Stack<User> stack;

    @Before
    public void setUp() throws Exception {
        stack = new StackImpl();
    }

    @After
    public void tearDown() throws Exception {
        stack = new StackImpl();
    }

    @Test
    public void push() {
        User user = new User(1, "张三");
        assertEquals(user,stack.push(user));
    }

    @Test
    public void empty() {
        User user = new User(1, "张三");
        stack.push(user);
        assertFalse(stack.empty());
    }

    @Test
    public void peek() {
        User user = new User(1, "张三");
        User user2 = new User(2, "李四");
        User user3 = new User(3, "王五");
        stack.push(user);
        stack.push(user2);
        stack.push(user3);
        assertEquals(user3,stack.peek());
        assertEquals(user3,stack.peek());
    }

    @Test
    public void pop() {
        User user = new User(1, "张三");
        User user2 = new User(2, "李四");
        User user3 = new User(3, "王五");
        stack.push(user);
        stack.push(user2);
        stack.push(user3);
        assertEquals(user3,stack.pop());
        assertEquals(user2,stack.pop());
        assertEquals(user,stack.pop());
    }


    @Test
    public void search() {
        User user = new User(1, "张三");
        User user2 = new User(2, "李四");
        User user3 = new User(3, "王五");
        stack.push(user);
        stack.push(user2);
        assertEquals(2,stack.search(user));
        assertEquals(1,stack.search(user2));
        assertEquals(-1,stack.search(user3));
    }
}