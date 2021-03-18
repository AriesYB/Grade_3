package org.ybiao.springcloud.provider2.service;

import org.ybiao.springcloud.provider2.bean.Patient;

import java.util.List;

/**
 * ClassName:PatientService
 * Package:org.ybiao.springcloud.provider2.service
 * Description:
 *
 * @Date:2020/3/19 16:35
 * @Author:HetFrame
 */
public interface PatientService {
    List<Patient> findAll();
    List<Patient> findByName(String name);
}
