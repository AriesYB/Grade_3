package org.ybiao.springcloud.provider1.service;

import org.ybiao.springcloud.provider1.bean.Disease;

import java.util.List;

/**
 * ClassName:DiseaseService
 * Package:org.ybiao.springcloud.provider.service
 * Description:
 *
 * @Date:2020/3/9 17:52
 * @Author:HetFrame
 */
public interface DiseaseService {
    public List<Disease> findAll();
    public List<Disease> findByName(String name);
}
