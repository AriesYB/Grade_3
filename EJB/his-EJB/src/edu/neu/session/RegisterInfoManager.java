package edu.neu.session;

import edu.neu.entity.RegisterInfo;
import edu.neu.pojo.PatientRegisterPage;

import java.util.List;

/**
 * ClassName:RegisterInfoManager
 * Package:edu.neu.session
 * Description:
 *
 * @Date:2019/10/24 22:53
 * @Author:HetFrame
 */
public interface RegisterInfoManager {
    public List<PatientRegisterPage> findById_Number(String id_number);
}
