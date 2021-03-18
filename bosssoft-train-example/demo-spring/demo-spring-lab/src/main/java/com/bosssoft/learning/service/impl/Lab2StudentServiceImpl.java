package com.bosssoft.learning.service.impl;

import com.bosssoft.learning.bean.Student;
import com.bosssoft.learning.service.Lab2StudentService;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description 操作学生实现类
 * @Date 2020/6/5 18:22
 * @Author HetFrame
 */
@Slf4j
public class Lab2StudentServiceImpl implements Lab2StudentService {
    @Override
    public void save(Student student) {
      log.info("---学生被保存:"+student.toString());
    }

    public void init(){
        log.info("---StudentServiceImpl被初始化---");
    }
    public void destroy(){
        log.info("---StudentServiceImpl被销毁---");
    }

}
