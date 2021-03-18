package org.ybiao.springcloud.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ybiao.springcloud.consumer.bean.Department;
import org.ybiao.springcloud.consumer.bean.Disease;
import org.ybiao.springcloud.consumer.bean.Drugs;
import org.ybiao.springcloud.consumer.bean.Patient;
import org.ybiao.springcloud.consumer.service.Provider1Service;
import org.ybiao.springcloud.consumer.service.Provider2Service;

import java.util.List;

/**
 * ClassName:CallController
 * Package:org.ybiao.springcloud.consumer.controller
 * Description:
 *
 * @Date:2020/3/9 19:16
 * @Author:HetFrame
 */
@RestController
@RequestMapping("/consumer")
public class CallController {
    @Autowired
    private Provider1Service provider1Service;

    @Autowired
    private Provider2Service provider2Service;

    @RequestMapping("/department/findAll")
    public List<Department> findAllDepartment() {
        return provider1Service.findAllDepartment();
    }

    @RequestMapping("/disease/findAll")
    public List<Disease> findAllDisease() {
        return provider1Service.findAllDisease();
    }

    @RequestMapping("/disease/find/{name}")
    public List<Disease> findDiseaseByName(@PathVariable String name) {
        return provider1Service.findDiseaseByName(name);
    }

    @RequestMapping("/drugs/findAll")
    public List<Drugs> findAllDrugs() {
        return provider1Service.findAllDrugs();
    }

    @RequestMapping("/drugs/find/{name}")
    public List<Drugs> findDrugsByName(@PathVariable String name) {
        return provider1Service.findDrugsByName(name);
    }


    @RequestMapping("/patient/findAll")
    public List<Patient> findAllPatient() {
        return provider2Service.findAll();
    }

    @RequestMapping("/patient/find/{name}")
    public List<Patient> findPatientByName(@PathVariable String name) {
        return provider2Service.findByName(name);
    }

    @RequestMapping("/discovery")
    public Object discovery() {
        return provider2Service.discovery();
    }
}
