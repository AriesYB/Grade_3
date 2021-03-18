package com.example.demo.service.iml;

import com.example.demo.bean.Country;
import com.example.demo.bean.CountryExample;
import com.example.demo.mapper.CountryMapper;
import com.example.demo.service.CountryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName:CountryServiceIml
 * Package:com.example.demo.service
 * Description:
 *
 * @Date:2020/3/8 19:32
 * @Author:HetFrame
 */
@Service
public class CountryServiceIml implements CountryService {
    @Resource
    CountryMapper countryMapper;

    @Override
    public List<Country> findAll(){
        CountryExample countryExample = new CountryExample();
        return countryMapper.selectByExample(countryExample);
    }

    @Override
    public Country findByCode(String code) {
        CountryExample countryExample = new CountryExample();
        CountryExample.Criteria criteria = countryExample.createCriteria();
        criteria.andCodeEqualTo(code);
        return countryMapper.selectByExample(countryExample).get(0);
    }
}
