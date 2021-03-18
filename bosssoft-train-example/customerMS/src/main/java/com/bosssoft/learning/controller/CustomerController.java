package com.bosssoft.learning.controller;

import com.bosssoft.learning.entity.Customer;
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
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/login")
    public boolean login(@RequestParam("id") Integer id,@RequestParam("password") String password) {
        return customerService.checkAccount(id, password);
    }

    @GetMapping("/getCustomer")
    public Customer getCustomer(@Range(min = 20170000, max = 20180000) @RequestParam("id") int id) {
        return customerService.getCustomerById(id);
    }

    @GetMapping("/listCustomerByName")
    public List<Customer> listCustomerByName(@NotBlank String name) {
        return customerService.listCustomerByName(name);
    }

    @GetMapping("/listCustomerAll")
    public List<Customer> getCustomerAll() {
        return customerService.listCustomerAll();
    }

    @PostMapping("/updateCustomer")
    public boolean updateCustomer(@Validated @RequestBody Customer customer) {
        return customerService.updateCustomer(customer);
    }

    @PostMapping("/saveCustomer")
    public boolean saveCustomer(@Validated @RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @PostMapping("/removeCustomer")
    public boolean removeCustomer(@Digits(message = "必须为整数", integer = 10, fraction = 0) @Range(min = 20175000, max = 20180000) @RequestParam("id") int id) {
        return customerService.removeCustomer(id);
    }

    @PostMapping("/removeCustomerList")
    public boolean removeCustomerList(@RequestBody List<Integer> list){
        return customerService.removeCustomerList(list);
    }

}
