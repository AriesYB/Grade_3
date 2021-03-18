package org.ybiao.springcloud.provider1.service;

import org.ybiao.springcloud.provider1.bean.Drugs;

import java.util.List;

/**
 * ClassName:DrugsService
 * Package:org.ybiao.springcloud.provider.service
 * Description:
 *
 * @Date:2020/3/9 17:52
 * @Author:HetFrame
 */
public interface DrugsService {
    public List<Drugs> findAll();
    public List<Drugs> findByName(String name);
}
