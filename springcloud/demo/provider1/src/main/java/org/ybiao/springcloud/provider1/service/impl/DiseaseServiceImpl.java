package org.ybiao.springcloud.provider1.service.impl;

import org.springframework.stereotype.Service;
import org.ybiao.springcloud.provider1.bean.Disease;
import org.ybiao.springcloud.provider1.bean.DiseaseExample;
import org.ybiao.springcloud.provider1.mapper.DiseaseMapper;
import org.ybiao.springcloud.provider1.service.DiseaseService;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName:DiseaseServiceImpl
 * Package:org.ybiao.springcloud.provider.service.impl
 * Description:
 *
 * @Date:2020/3/9 18:07
 * @Author:HetFrame
 */
@Service
public class DiseaseServiceImpl implements DiseaseService {
    @Resource
    DiseaseMapper diseaseMapper;

    @Override
    public List<Disease> findAll() {
        DiseaseExample diseaseExample = new DiseaseExample();
        return diseaseMapper.selectByExample(diseaseExample);
    }

    @Override
    public List<Disease> findByName(String name) {
        DiseaseExample diseaseExample = new DiseaseExample();
        diseaseExample.createCriteria().andDiseasenameLike("%"+name+"%");
        return diseaseMapper.selectByExample(diseaseExample);
    }
}
