package org.ybiao.springcloud.provider1.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ybiao.springcloud.provider1.bean.Department;
import org.ybiao.springcloud.provider1.bean.Disease;
import org.ybiao.springcloud.provider1.bean.Drugs;
import org.ybiao.springcloud.provider1.service.DepartmentService;
import org.ybiao.springcloud.provider1.service.DiseaseService;
import org.ybiao.springcloud.provider1.service.DrugsService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:HisController
 * Package:org.ybiao.springcloud.provider1.controller
 * Description:
 *
 * @Date:2020/3/9 17:51
 * @Author:HetFrame
 */
@RestController
public class HisController {
    @Resource
    DepartmentService departmentService;
    @Resource
    DiseaseService diseaseService;
    @Resource
    DrugsService drugsService;

    @RequestMapping("/department/findAll")
    public List<Department> findAllDepartment() {
        return departmentService.findAll();
    }

    @RequestMapping("/disease/findAll")
    public List<Disease> findAllDisease() {
        return diseaseService.findAll();
    }

    @RequestMapping("/disease/find/{name}")
    public List<Disease> findDiseaseByName(@PathVariable String name) {
        return diseaseService.findByName(name);
    }

    @RequestMapping("/drugs/findAll")
    public List<Drugs> findAllDrugs() {
        return drugsService.findAll();
    }

    @HystrixCommand(fallbackMethod = "drugNotFound")
    @RequestMapping("/drugs/find/{name}")
    public List<Drugs> findDrugsByName(@PathVariable String name) throws Exception {
        List<Drugs> list =  drugsService.findByName(name);
        if (list.isEmpty()){
            throw new Exception();
        }
        return list;
    }
    public List<Drugs> drugNotFound(@PathVariable("name") String name){
        Drugs drugs = new Drugs();
        drugs.setDrugscode("未查询到名为'"+name+"'的药品！");
        List<Drugs> list = new ArrayList<>();
        list.add(drugs);
        return list;
    }

}
