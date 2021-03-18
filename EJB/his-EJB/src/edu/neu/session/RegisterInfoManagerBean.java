package edu.neu.session;

import edu.neu.entity.RegisterInfo;
import edu.neu.pojo.PatientRegisterPage;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Iterator;
import java.util.List;

/**
 * ClassName:RegisterInfoManagerBean
 * Package:edu.neu.session
 * Description:
 *
 * @Date:2019/10/24 22:55
 * @Author:HetFrame
 */
@Remote
@Stateless(name = "registerInfoManagerBean")
public class RegisterInfoManagerBean implements RegisterInfoManager {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<PatientRegisterPage> findById_Number(String id_number) {
//        Query query = em.createQuery("select p.name,p.address,r.id,r.time,r.see_doctor_time,d.DeptName,r.status from Patient p inner join RegisterInfo r on p.ID_number=r.ID_number inner join Department d on r.department =d.id where r.ID_number=?1");
        Query query =em.createQuery("select r from RegisterInfo r where r.ID_number =?1");
        List result = query.setParameter(1,id_number).getResultList();
        Iterator iterator = result.iterator();
        while (iterator.hasNext()){
//            PatientRegisterPage patientRegisterPage = (PatientRegisterPage) iterator.next();
//            System.out.println(patientRegisterPage.toString());
            RegisterInfo registerInfo = (RegisterInfo) iterator.next();
            System.out.println(registerInfo.toString());
        }
        return null;
    }
}
