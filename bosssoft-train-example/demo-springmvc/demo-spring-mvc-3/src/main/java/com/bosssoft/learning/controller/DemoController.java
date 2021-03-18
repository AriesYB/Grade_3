package com.bosssoft.learning.controller;

import com.bosssoft.learning.bean.Student;
import com.bosssoft.learning.exception.BusinessException;
import com.bosssoft.learning.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
    private StudentService studentService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/login")
    public String login(@RequestParam("id") String id, HttpServletRequest request) {
        Student student = studentService.getStudentById(id);
        if (student != null) {
            request.getSession(true).setAttribute("student", student.getId());
            return "success";
        }
        return  "failure";
    }

    @GetMapping("/getAllStudent")
    public List<Student> getAllStudent(HttpServletRequest request) throws BusinessException {
        if (request.getSession().getAttribute("student").equals("123")){
            throw new BusinessException("该学生不允许查询异常");
        }
        return studentService.listStudentAll();
    }

    @ExceptionHandler(BusinessException.class)
    public ModelAndView handleStudentException(Exception e){
        ModelAndView mv =new ModelAndView();
        mv.addObject("exception",e);
        mv.setViewName("error");
        return mv;
    }
}
