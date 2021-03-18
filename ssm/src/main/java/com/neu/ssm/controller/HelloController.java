package com.neu.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ClassName:HelloController
 * Package:com.neu.ssm.controller
 * Description:
 *
 * @Date:2020/3/8 16:59
 * @Author:HetFrame
 */
@Controller
public class HelloController {
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
    return "Hello World!";
    }
}
