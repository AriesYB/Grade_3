package edu.neu.session;

import edu.neu.vo.RefundPage;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ClassName:ChargeDetailManagerBean
 * Package:edu.neu.session
 * Description:
 *
 * @Date:2019/10/26 17:00
 * @Author:HetFrame
 */
@Remote
@Stateless(name = "chargeDetailManagerBean")
public class ChargeDetailManagerBean implements ChargeDetailManager {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<RefundPage> getChargeDetails(String id_number) {
        Query query = em.createQuery("select new edu.neu.vo.RefundPage(pa.name,c.register_id,p.medical_record_num,de.DeptName,u.name,d.DrugsName,c.quantity,i.amount,c.charge_method,c.time,pi.status) from ChargesDetail c inner join Prescription p on c.register_id = p.register_id inner join RegisterInfo r on p.register_id = r.id inner join Patient pa on r.ID_number = pa.ID_number inner join PrescriptionItem pi on pi.id = c.project inner join Drug d on pi.drug = d.id inner join Department de on r.department = de.id inner join User u on p.doctor = u.id inner join Invoice i on c.invoice = i.invoice_id where c.type=1 and pi.charge_status=2 and pa.ID_number=?1 and c.isDeleted=0 and p.isDeleted=0 and pi.isDeleted=0 and r.isDeleted=0 and pa.isDeleted=0 and de.isDeleted=0 and u.isDeleted=0");
        List result = query.setParameter(1, id_number).getResultList();
        List<RefundPage> list = new ArrayList<>();
        for (Object o : result) {
            RefundPage refundPage = (RefundPage) o;
            list.add(refundPage);
            System.out.println(refundPage);
            switch (refundPage.getStatus()) {
                case "1":
                    refundPage.setStatus("未发药");
                    break;
                case "2":
                    refundPage.setStatus("已发药");
                    break;
                case "3":
                    refundPage.setStatus("已退药");
                    break;
            }
        }
        return list;
    }
}
