package edu.neu.session;

import edu.neu.pojo.PatientRegisterPage;

import javax.ejb.Remote;
import java.util.List;

/**
 * ClassName:Unregister
 * Package:edu.neu.session.stateless
 * Description:
 *
 * @Date:2019/10/24 11:48
 * @Author:HetFrame
 */
@Remote
public interface Unregister {
    public List<PatientRegisterPage> getPatientRegister(String id_number);
}
