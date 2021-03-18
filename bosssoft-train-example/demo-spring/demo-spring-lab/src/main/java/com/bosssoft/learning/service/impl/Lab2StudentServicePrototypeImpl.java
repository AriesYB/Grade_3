package com.bosssoft.learning.service.impl;

import com.bosssoft.learning.bean.Student;
import com.bosssoft.learning.service.Lab2StudentService;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description 第二个service
 * @Date 2020/6/6 13:36
 * @Author HetFrame
 */
@Slf4j
public class Lab2StudentServicePrototypeImpl implements Lab2StudentService {
    @Override
    public void save(Student student) {
        // 123
    }
    public void init(){
        log.info("---StudentServiceImpl2被初始化---");
    }
    public void destroy(){
        log.info("---StudentServiceImpl2被销毁---");
    }

}
