package com.bosssoft.learning.controller;

import com.bosssoft.learning.bean.Student;
import com.bosssoft.learning.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description rest
 * @Date 2020/6/7 18:25
 * @Author HetFrame
 */

@Slf4j
@org.springframework.web.bind.annotation.RestController
public class RestController {
    private StudentService service;

    @Autowired
    @Qualifier("studentService1")
    public void setService(StudentService service) {
        this.service = service;
    }

    @GetMapping("/listStudentAll")
    public List<Student> listStudentAll() {
        return service.listStudentAll();
    }

    @PostMapping("/listStudentAllPost")
    public List<Student> listStudentAll1() {
        return service.listStudentAll();
    }

    @GetMapping("/listStudentAllGet")
    public List<Student> listStudentAll2() {
        return service.listStudentAll();
    }

    @GetMapping("/displayHeaderInfo")
    public Map<String, Object> displayHeaderInfo(@RequestHeader("User-agent") String userAgent,
@RequestHeader(value = "Accept") String accept, @CookieValue("JSESSIONID") String cookie) {
        Map<String, Object> map = new HashMap<>(3);
        map.put("accepts", accept);
        map.put("userAgent", userAgent);
        map.put("cookie", cookie);
        return map;
    }

    @GetMapping("/updateStudent")
    public Student updateStudent(@RequestParam("id") String studentId, @RequestParam("name") String name, @RequestParam("age") int age) {
        return service.updateStudent(new Student(studentId, name, age));
    }

    @GetMapping("/getStudentById/{id}")
    public Student getStudentById(@PathVariable("id") String id) {
        return service.getStudentById(id);
    }

}
