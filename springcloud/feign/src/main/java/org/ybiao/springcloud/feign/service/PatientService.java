package org.ybiao.springcloud.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.ybiao.springcloud.feign.bean.Patient;

import java.util.List;

/**
 * ClassName:PatientService
 * Package:org.ybiao.springcloud.feign.service
 * Description:
 *
 * @Date:2020/3/22 12:34
 * @Author:HetFrame
 */
@Service
@FeignClient("provider2")
public interface PatientService {

    @RequestMapping("/patient/findAll")
    List<Patient> findAll();

    @RequestMapping("/patient/find/{name}")
    List<Patient> findByName(@PathVariable String name);
}
