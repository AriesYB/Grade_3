package com.bosssoft.learning.controller;

import com.bosssoft.learning.bean.Student;
import com.bosssoft.learning.common.MyLogApi;
import com.bosssoft.learning.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description demo
 * @Date 2020/6/6 23:36
 * @Author HetFrame
 */

@Slf4j
@Controller
public class DemoController {

    private StudentService service;

    @Autowired
    public void setService(StudentService service) {
        this.service = service;
    }

    @MyLogApi(action = "获取学生")
    @GetMapping("/getStudent")
    @ResponseBody
    public Student getStudent(HttpServletRequest request) {
        return service.getStudentById("123");
    }

}
