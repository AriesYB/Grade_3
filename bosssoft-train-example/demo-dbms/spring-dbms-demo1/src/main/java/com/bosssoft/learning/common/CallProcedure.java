package com.bosssoft.learning.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * @Description 调用存储过程
 * @Date 2020/6/10 8:50
 * @Author HetFrame
 */
@Component
public class CallProcedure {

    private static final String SQL = "call init_dbms(?,?)";
    private JdbcTemplate template;

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public int doCall() {
        return template.update(SQL, 100000, 10);
    }
}
