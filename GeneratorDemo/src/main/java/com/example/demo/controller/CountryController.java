package com.example.demo.controller;

import com.example.demo.bean.Country;
import com.example.demo.service.CountryService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName:CountryController
 * Package:com.example.demo.controller
 * Description:
 *
 * @Date:2020/3/8 19:29
 * @Author:HetFrame
 */
@RestController
@RequestMapping("country")
public class CountryController {
    @Resource
    CountryService countryService;

    @RequestMapping("/findAll")
    public List<Country> findAll(){
        return countryService.findAll();
    }
    @RequestMapping("/find/{code}")
    public Country findByCode(@PathVariable String code){
        return countryService.findByCode(code);
    }
}
