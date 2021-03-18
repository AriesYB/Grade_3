package org.ybiao.springcloud.provider4.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.ybiao.springcloud.provider4.bean.Patient;
import org.ybiao.springcloud.provider4.service.PatientService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:PatientController
 * Package:org.ybiao.springcloud.provider2.controller
 * Description:
 *
 * @Date:2020/3/19 16:52
 * @Author:HetFrame
 */
@RestController
public class PatientController {
    @Resource
    private PatientService patientService;

    @Autowired
    private DiscoveryClient client;

    @RequestMapping("/patient/findAll")
    public List<Patient> findAll() {
        return patientService.findAll();
    }

    @HystrixCommand(fallbackMethod = "patientNotFound")
    @RequestMapping("/patient/find/{name}")
    public List<Patient> findByName(@PathVariable String name) throws Exception {
        List<Patient> list = patientService.findByName(name);
        if (list.isEmpty()) {//未找到病人抛出异常进行服务熔断
            throw new Exception();
        }
        list.get(0).setProvider("provider-02-3");
        return list;
    }

    public List<Patient> patientNotFound(@PathVariable("name") String name) {
        List<Patient> patientList = new ArrayList<>();
        Patient patient = new Patient();
        patient.setName(name);
        patient.setDateBirth("未找到名为'" + name + "'的病人信息!");
        patient.setProvider("provider-02-3");
        patientList.add(patient);
        return patientList;
    }

    @RequestMapping(value = "/discovery", method = RequestMethod.GET)
    public Object discovery() {
        //获取所有服务id(服务的name)
        List<String> list = client.getServices();
        System.out.println("------------------" + list + "------------------");
        for (String srvId : list) {
            //获取所有服务实例
            List<ServiceInstance> instances = client.getInstances(srvId);
            for (ServiceInstance instance : instances) {
                System.out.println(instance.getInstanceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri() + "\n");
            }
        }
        return this.client;
    }

}
