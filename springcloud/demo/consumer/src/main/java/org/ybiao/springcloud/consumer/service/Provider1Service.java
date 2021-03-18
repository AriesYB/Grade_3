package org.ybiao.springcloud.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.ybiao.springcloud.consumer.bean.Department;
import org.ybiao.springcloud.consumer.bean.Disease;
import org.ybiao.springcloud.consumer.bean.Drugs;
import org.ybiao.springcloud.consumer.config.Provider1ServiceFallbackFactory;

import java.util.List;

/**
 * ClassName:Provider1Service
 * Package:org.ybiao.springcloud.consumer.service
 * Description:
 *
 * @Date:2020/4/16 18:28
 * @Author:HetFrame
 */
@Service
@FeignClient(value = "provider1", fallbackFactory = Provider1ServiceFallbackFactory.class)
public interface Provider1Service {
    @RequestMapping("/department/findAll")
    List<Department> findAllDepartment();

    @RequestMapping("/disease/findAll")
    List<Disease> findAllDisease();

    @RequestMapping("/disease/find/{name}")
    List<Disease> findDiseaseByName(@PathVariable String name);

    @RequestMapping("/drugs/findAll")
    List<Drugs> findAllDrugs();

    @RequestMapping("/drugs/find/{name}")
    List<Drugs> findDrugsByName(@PathVariable String name);
}
