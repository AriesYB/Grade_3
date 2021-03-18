package edu.neu.session;

import edu.neu.vo.UnregisterPage;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
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
    public List<UnregisterPage> findById_Number(String id_number) {
        Query query = em.createQuery("select new edu.neu.vo.UnregisterPage(p.name,p.address,r.id,r.time,r.see_doctor_time,d.DeptName,r.status,u.name,u.professional_ranks_and_titles) from Patient p inner join RegisterInfo r on p.ID_number=r.ID_number inner join Department d on r.department =d.id inner join User u on r.doctor = u.id where r.ID_number=?1 and p.isDeleted=0 and r.isDeleted=0 and d.isDeleted=0 order by r.id desc");
        List result = query.setParameter(1, id_number).getResultList();
        Iterator iterator = result.iterator();
        List<UnregisterPage> list = new ArrayList<>();
        while (iterator.hasNext()) {
            UnregisterPage unregisterPage = (UnregisterPage) iterator.next();
            switch (unregisterPage.getStatus()) {
                case "1":
                    unregisterPage.setStatus("未诊");
                    break;
                case "2":
                    unregisterPage.setStatus("已诊");
                    break;
                case "3":
                    unregisterPage.setStatus("已退号");
                    break;
            }
            list.add(unregisterPage);
        }
        System.out.println(list);
        return list;
    }

    @Override
    public Integer unregister(int register_id) {
        Query query = em.createQuery("update RegisterInfo r set r.status = ?1 where r.id =?2 and r.isDeleted=0");
        int count = query.setParameter(1, "3").setParameter(2, register_id).executeUpdate();
        System.out.println(register_id + "退号处理记录条数:" + count);
        return new Integer(1);
    }
}
