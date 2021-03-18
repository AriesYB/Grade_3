package org.ybiao.springcloud.provider1.service.impl;

import org.springframework.stereotype.Service;
import org.ybiao.springcloud.provider1.bean.Drugs;
import org.ybiao.springcloud.provider1.bean.DrugsExample;
import org.ybiao.springcloud.provider1.mapper.DrugsMapper;
import org.ybiao.springcloud.provider1.service.DrugsService;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName:DrugsServiceImpl
 * Package:org.ybiao.springcloud.provider.service.impl
 * Description:
 *
 * @Date:2020/3/9 18:08
 * @Author:HetFrame
 */
@Service
public class DrugsServiceImpl implements DrugsService {
    @Resource
    DrugsMapper drugsMapper;


    @Override
    public List<Drugs> findAll() {
        DrugsExample drugsExample = new DrugsExample();
        return drugsMapper.selectByExample(drugsExample);
    }

    @Override
    public List<Drugs> findByName(String name) {
        DrugsExample drugsExample = new DrugsExample();
        drugsExample.createCriteria().andDrugsnameLike("%" + name + "%");
        return drugsMapper.selectByExample(drugsExample);
    }
}
