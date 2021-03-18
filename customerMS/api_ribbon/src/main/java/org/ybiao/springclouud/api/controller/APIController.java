package org.ybiao.springclouud.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName:APIController
 * Package:org.ybiao.springclouud.api.controller
 * Description:
 *
 * @Date:2020/5/5 16:52
 * @Author:HetFrame
 */
@RestController
public class APIController {
    private static final String REST_URL_1_PREFIX = "http://customer1";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/api_ribbon/findById/{id}")
    public Object findCustomerById(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(REST_URL_1_PREFIX + "/customer/findById/" + id, Object.class);
    }
}
