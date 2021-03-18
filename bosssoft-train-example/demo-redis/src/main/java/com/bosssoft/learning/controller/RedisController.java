package com.bosssoft.learning.controller;

import com.bosssoft.learning.entity.CustomerVO;
import com.bosssoft.learning.service.CustomerService;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @Description 前端控制器
 * @Date 2020/6/16 11:47
 * @Author HetFrame
 */
@CrossOrigin
@Validated
@RestController
public class RedisController {
    private CustomerService service;

    @Autowired
    public void setService(CustomerService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public boolean validateAccount(@RequestParam("id") Integer id, @RequestParam("password") String password) {
        return service.checkAccount(id, password);
    }

    @GetMapping("/getCustomer")
    public CustomerVO getCustomerById(@Range(min = 20170000, max = 20180000) @RequestParam("id") int id) {
        if (id==20180000){
            return service.getCustomerById2(id);
        }
        return service.getCustomerById(id);
    }

    @GetMapping("/listCustomerByName")
    public List<CustomerVO> listCustomerByName(@NotBlank String name) {
        return service.listCustomerByName(name);
    }

    @GetMapping("/listCustomerAll")
    public List<CustomerVO> getCustomerAll() {
        return service.listCustomerAll();
    }

    @PostMapping("/updateCustomer")
    public boolean updateCustomer(@Validated @RequestBody CustomerVO customer) {
        return service.updateCustomer(customer);
    }

    @PostMapping("/saveCustomer")
    public boolean saveCustomer(@Validated @RequestBody CustomerVO customer) {
        return service.saveCustomer(customer);
    }

    @PostMapping("/removeCustomer")
    public boolean removeCustomerById(@Digits(message = "必须为整数", integer = 10, fraction = 0) @Range(min = 20175000, max = 20180000) @RequestParam("id") int id) {
        return service.removeCustomer(id);
    }

    @PostMapping("/removeCustomerList")
    public boolean removeList(@RequestBody List<Integer> list){
        return service.removeCustomerList(list);
    }

}
