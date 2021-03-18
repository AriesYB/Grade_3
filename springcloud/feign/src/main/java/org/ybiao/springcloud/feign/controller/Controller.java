package org.ybiao.springcloud.feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ybiao.springcloud.feign.bean.Patient;
import org.ybiao.springcloud.feign.service.PatientService;

import java.util.List;

/**
 * ClassName:Controller
 * Package:org.ybiao.springcloud.feign.controller
 * Description:
 *
 * @Date:2020/3/22 12:33
 * @Author:HetFrame
 */
@RestController
public class Controller {
    @Autowired
    private PatientService patientService;

    @RequestMapping("/consumer/patient/findAll")
    public List<Patient> findPatientAll() {
        return patientService.findAll();
    }

    @RequestMapping("/consumer/patient/find/{name}")
    public List<Patient> findPatientByName(@PathVariable String name) {
        return patientService.findByName(name);
    }
}
