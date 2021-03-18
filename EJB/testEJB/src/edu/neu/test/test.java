package edu.neu.test;

import edu.neu.factory.EJBFactory;
import edu.neu.vo.RefundPage;
import edu.neu.session.ChargeDetailManager;
import edu.neu.session.RegisterInfoManager;
import edu.neu.vo.UnregisterPage;

import java.util.List;

/**
 * ClassName:test
 * Package:edu.neu
 * Description:
 *
 * @Date:2019/10/22 11:55
 * @Author:HetFrame
 */
public class test {
    public static void main(String[] args) {
//        Refund refund = (Refund) EJBFactory.getEJB("ejb:/EJB-his/refundBean!edu.neu.session.Refund");
//        if (refund != null) {
//            System.out.println(refund.refund("yangbiao"));
//        }
        RegisterInfoManager registerInfoManager = (RegisterInfoManager) EJBFactory.getEJB("ejb:/EJB-his/registerInfoManagerBean!edu.neu.session.RegisterInfoManager");
        List<UnregisterPage> list = registerInfoManager.findById_Number("511023199809071120");
        for (UnregisterPage p : list
        ) {
            System.out.println(p.toString());
        }

        ChargeDetailManager chargeDetailManager = (ChargeDetailManager) EJBFactory.getEJB("ejb:/EJB-his/chargeDetailManagerBean!edu.neu.session.ChargeDetailManager");
        List<RefundPage> list1 = chargeDetailManager.getChargeDetails("51102319980803151X");
        for (RefundPage r : list1
        ) {
            System.out.println(r.toString());
        }
    }
}
