package org.ybiao.springcloud.provider1.service;

import org.ybiao.springcloud.provider1.bean.Department;

import java.util.List;

/**
 * ClassName:DepartmentService
 * Package:org.ybiao.springcloud.provider.service
 * Description:
 *
 * @Date:2020/3/9 17:52
 * @Author:HetFrame
 */
public interface DepartmentService {
    public List<Department> findAll();
}
