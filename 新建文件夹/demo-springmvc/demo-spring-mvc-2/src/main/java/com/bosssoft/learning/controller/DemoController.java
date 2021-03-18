package com.bosssoft.learning.controller;

import com.bosssoft.learning.bean.Student;
import com.bosssoft.learning.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Description rest
 * @Date 2020/6/7 18:25
 * @Author HetFrame
 */

@Slf4j
@RestController
public class DemoController {
    private StudentService service;

    @Autowired
    public void setService(StudentService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public String login(@RequestParam("id") String id, HttpServletRequest request) {
        Student student = service.getStudentById(id);
        if (student != null) {
            request.getSession(true).setAttribute("student", student.getId());
            return "success";
        }
        return  "failure";
    }

    @GetMapping("/getAllStudent")
    public List<Student> getAllStudent() {
        return service.listStudentAll();
    }

}
