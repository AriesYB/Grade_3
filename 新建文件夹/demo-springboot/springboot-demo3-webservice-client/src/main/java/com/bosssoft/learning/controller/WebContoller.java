package com.bosssoft.learning.controller;

import com.bosssoft.learning.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description controller
 * @Date 2020/6/11 17:14
 * @Author HetFrame
 */
@RestController
public class WebContoller {

    private WebService webService;

    @Autowired
    public void setWebService(WebService webService) {
        this.webService = webService;
    }

    @GetMapping("/webservice")
    public Object callWebService(@RequestParam("word") String word) {
        return webService.getTranslationByWebService(word);
    }
}
