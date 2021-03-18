package org.ybiao.springcloud.consumer.config;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.ybiao.springcloud.consumer.bean.Department;
import org.ybiao.springcloud.consumer.bean.Disease;
import org.ybiao.springcloud.consumer.bean.Drugs;
import org.ybiao.springcloud.consumer.service.Provider1Service;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:Provider1ServiceFallbackFactory
 * Package:org.ybiao.springcloud.consumer.config
 * Description:
 *
 * @Date:2020/4/16 18:58
 * @Author:HetFrame
 */
@Component
public class Provider1ServiceFallbackFactory implements FallbackFactory {
    @Override
    public Object create(Throwable throwable) {
        return new Provider1Service() {
            @Override
            public List<Department> findAllDepartment() {
                List<Department> departments = new ArrayList<>();
                Department department = new Department();
                department.setId(-1);
                department.setDeptname("服务不可用，请稍后再试。");
                departments.add(department);
                return departments;
            }

            @Override
            public List<Disease> findAllDisease() {
                List<Disease> diseases = new ArrayList<>();
                Disease disease = new Disease();
                disease.setId(-1);
                disease.setDiseasename("服务不可用，请稍后再试。");
                diseases.add(disease);
                return diseases;
            }

            @Override
            public List<Disease> findDiseaseByName(String name) {
                List<Disease> diseases = new ArrayList<>();
                Disease disease = new Disease();
                disease.setId(-1);
                disease.setDiseasename("服务不可用，请稍后再试。");
                diseases.add(disease);
                return diseases;
            }

            @Override
            public List<Drugs> findAllDrugs() {
                List<Drugs> drugsList = new ArrayList<>();
                Drugs drug = new Drugs();
                drug.setId(-1);
                drug.setDrugsname("服务不可用，请稍后再试。");
                drugsList.add(drug);
                return drugsList;
            }

            @Override
            public List<Drugs> findDrugsByName(String name) {
                List<Drugs> drugsList = new ArrayList<>();
                Drugs drug = new Drugs();
                drug.setId(-1);
                drug.setDrugsname("服务不可用，请稍后再试。");
                drugsList.add(drug);
                return drugsList;
            }
        };
    }
//        return new Provider2Service() {
//            @Override
//            public List<Patient> findAll() {
//                List<Patient> patients = new ArrayList<>();
//                Patient patient = new Patient();
//                patient.setId(-1);
//                patient.setName("服务不可用，请稍后再试。");
//                patients.add(patient);
//                return patients;
//            }
//
//            @Override
//            public List<Patient> findByName(String name) {
//                List<Patient> patients = new ArrayList<>();
//                Patient patient = new Patient();
//                patient.setId(-1);
//                patient.setName(name);
//                patient.setDateBirth("服务不可用，请稍后再试。");
//                patients.add(patient);
//                return patients;
//            }
//
//            @Override
//            public Object discovery() {
//                return "服务不可用，请稍后再试。";
//            }
//        };
//    }
}
