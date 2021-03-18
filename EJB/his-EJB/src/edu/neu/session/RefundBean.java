package edu.neu.session;

import javax.ejb.Stateless;

/**
 * ClassName:RefundBean
 * Package:edu.neu.session.stateless
 * Description:
 *
 * @Date:2019/10/22 11:36
 * @Author:HetFrame
 */
@Stateless(name = "refundBean")
public class RefundBean implements Refund {
    @Override
    public String refund(String id) {
        return id+",远程调用refund";
    }
}
