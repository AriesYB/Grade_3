package edu.neu.session;

import javax.ejb.Remote;

/**
 * ClassName:Refund
 * Package:edu.neu.session.stateless
 * Description:
 *
 * @Date:2019/10/22 11:35
 * @Author:HetFrame
 */
@Remote
public interface Refund {
    public String refund(String id);
}
