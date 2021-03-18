package com.bosssoft.learning.controller;

import com.bosssoft.learning.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 使用ribbon的消费者的controller
 * @Date 2020/6/22 19:57
 * @Author HetFrame
 */
@RestController
public class ClientController {

    private ClientService service;

    @Autowired
    public void setService(ClientService service) {
        this.service = service;
    }

    @GetMapping("/ribbon/test")
    public String testRibbon(){
        return service.test();
    }


}
