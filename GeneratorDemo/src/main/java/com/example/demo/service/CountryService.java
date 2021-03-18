package com.example.demo.service;

import com.example.demo.bean.Country;

import java.util.List;

/**
 * ClassName:CountryService
 * Package:com.example.demo.service
 * Description:
 *
 * @Date:2020/3/8 20:50
 * @Author:HetFrame
 */
public interface CountryService {
    public List<Country> findAll();
    public Country findByCode(String code);
}
