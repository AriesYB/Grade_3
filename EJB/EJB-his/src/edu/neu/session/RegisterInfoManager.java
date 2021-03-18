package edu.neu.session;

import edu.neu.vo.UnregisterPage;

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
    public List<UnregisterPage> findById_Number(String id_number);
    public Integer unregister(int register_id);
}
