package com.bosssoft.hr.train.j2se.basic.example.annotation;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author HetFrame
 * @Description TODO
 * @date 2020/6/1 8:50
 */
@Slf4j
public class UserModelTest {

    @Test
    public void save() {
        UserModel model = new UserModel(100, "杨彪", 21);
        assertEquals(1, model.save());
        model.remove();
    }

    @Test
    public void update() {
        UserModel model = new UserModel(2, "张三", 21);
        assertEquals(1, model.update());
    }

    @Test
    public void remove() {
        new UserModel(100, "100", 100).save();
        UserModel model = new UserModel(100);
        assertFalse(model.query().isEmpty());
        assertEquals(1, model.remove());
        assertTrue(model.query().isEmpty());
    }

    @Test
    public void query() {
        UserModel model = new UserModel(2);
        log.info(model.query().toString());
        assertNotNull(model.query());
    }
}