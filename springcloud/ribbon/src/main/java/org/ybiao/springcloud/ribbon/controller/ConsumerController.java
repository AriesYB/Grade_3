package org.ybiao.springcloud.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName:ConsumerController
 * Package:org.ybiao.springcloud.ribbon.controller
 * Description:
 *
 * @Date:2020/3/20 23:19
 * @Author:HetFrame
 */
@RestController
public class ConsumerController {
    private static final String REST_URL_1_PREFIX = "http://provider1";
    private static final String REST_URL_2_PREFIX = "http://provider2";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/discovery")
    public Object discovery() {
        return restTemplate.getForObject(REST_URL_2_PREFIX + "/discovery", Object.class);
    }

    @RequestMapping("/consumer/find/patient/{name}")
    public Object findPatientByName(@PathVariable String name){
        return restTemplate.getForObject(REST_URL_2_PREFIX+"/patient/find/"+name,Object.class);
    }
}
