package org.ybiao.springcloud.provider1.service.impl;

import org.springframework.stereotype.Service;
import org.ybiao.springcloud.provider1.bean.Department;
import org.ybiao.springcloud.provider1.bean.DepartmentExample;
import org.ybiao.springcloud.provider1.mapper.DepartmentMapper;
import org.ybiao.springcloud.provider1.service.DepartmentService;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName:DepartmentServiceIml
 * Package:org.ybiao.springcloud.provider.service.impl
 * Description:
 *
 * @Date:2020/3/9 18:06
 * @Author:HetFrame
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    DepartmentMapper departmentMapper;
    @Override
    public List<Department> findAll() {
        DepartmentExample departmentExample = new DepartmentExample();
        return departmentMapper.selectByExample(departmentExample);
    }
}
