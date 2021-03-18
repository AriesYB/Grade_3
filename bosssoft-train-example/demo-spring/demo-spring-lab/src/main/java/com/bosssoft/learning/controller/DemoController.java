package com.bosssoft.learning.controller;

import com.bosssoft.learning.common.MyLogApi;
import lombok.extern.slf4j.Slf4j;
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

    @MyLogApi(action = "测试日志方法")
    @GetMapping("/test")
    @ResponseBody
    public String testLog(HttpServletRequest request) {
        return "success!";
    }

}
