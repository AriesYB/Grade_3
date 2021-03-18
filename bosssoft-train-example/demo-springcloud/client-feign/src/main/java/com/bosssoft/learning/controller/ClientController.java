package com.bosssoft.learning.controller;

import com.bosssoft.learning.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description feign客户端
 * @Date 2020/6/22 21:06
 * @Author HetFrame
 */
@RestController
public class ClientController {

    private ClientService service;

    @Autowired
    public void setService(ClientService service) {
        this.service = service;
    }

    @GetMapping("/feign/test")
    public String testFeign(){
        return service.test();
    }
}
