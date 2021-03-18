package edu.neu.session;

import edu.neu.vo.RefundPage;

import java.util.List;

/**
 * ClassName:ChargeDetailManager
 * Package:edu.neu.session
 * Description:
 *
 * @Date:2019/10/26 16:57
 * @Author:HetFrame
 */

public interface ChargeDetailManager {
    public List<RefundPage> getChargeDetails(String id_number);
}
