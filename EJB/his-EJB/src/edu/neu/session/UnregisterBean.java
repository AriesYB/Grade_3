package edu.neu.session;

import edu.neu.pojo.PatientRegisterPage;

import javax.ejb.Stateless;
import java.util.List;

/**
 * ClassName:UnregisterBean
 * Package:edu.neu.session.stateless
 * Description:
 *
 * @Date:2019/10/24 11:52
 * @Author:HetFrame
 */
@Stateless(name = "unregisterBean")
public class UnregisterBean implements Unregister {
    @Override
    public List<PatientRegisterPage> getPatientRegister(String id_number) {

        return null;
    }
}
