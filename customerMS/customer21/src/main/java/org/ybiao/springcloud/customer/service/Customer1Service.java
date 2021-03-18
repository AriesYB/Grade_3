package org.ybiao.springcloud.customer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.ybiao.springcloud.customer.bean.Customer;

/**
 * ClassName:Customer1Service
 * Package:org.ybiao.springcloud.customer.service
 * Description: 使用feign调用customer1中查询方法
 *
 * @Date:2020/5/5 20:54
 * @Author:HetFrame
 */
@Service
@FeignClient("customer1")
public interface Customer1Service {
    @RequestMapping("/customer/findById/{id}")
    Customer findCustomerById(@PathVariable("id") Integer id);
}
