package org.ybiao.springcloud.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.ybiao.springcloud.consumer.bean.Patient;

import java.util.List;

/**
 * ClassName:PatientService
 * Package:org.ybiao.springcloud.consumer.service
 * Description:
 *
 * @Date:2020/4/16 18:10
 * @Author:HetFrame
 */
@Service
@FeignClient("provider2")
public interface Provider2Service {
    @RequestMapping("/patient/findAll")
    List<Patient> findAll();

    @RequestMapping("/patient/find/{name}")
    List<Patient> findByName(@PathVariable String name);

    @RequestMapping("/discovery")
    Object discovery();
}
