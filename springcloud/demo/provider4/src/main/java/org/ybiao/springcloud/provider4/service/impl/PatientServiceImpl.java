package org.ybiao.springcloud.provider4.service.impl;

import org.springframework.stereotype.Service;
import org.ybiao.springcloud.provider4.bean.Patient;
import org.ybiao.springcloud.provider4.bean.PatientExample;
import org.ybiao.springcloud.provider4.mapper.PatientMapper;
import org.ybiao.springcloud.provider4.service.PatientService;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName:PatientServiceImpl
 * Package:org.ybiao.springcloud.provider2.service.impl
 * Description:
 *
 * @Date:2020/3/19 16:36
 * @Author:HetFrame
 */
@Service
public class PatientServiceImpl implements PatientService {

    @Resource
    private PatientMapper patientMapper;

    @Override
    public List<Patient> findAll() {
        PatientExample patientExample = new PatientExample();
        patientExample.createCriteria().andIsdeletedEqualTo(0);
        return patientMapper.selectByExample(patientExample);
    }

    @Override
    public List<Patient> findByName(String name) {
        PatientExample patientExample = new PatientExample();
        patientExample.createCriteria().andIsdeletedEqualTo(0).andNameEqualTo(name);
        return patientMapper.selectByExample(patientExample);
    }
}
