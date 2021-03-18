package com.boss.xtrain.util.bean;

import net.sf.cglib.beans.BeanCopier;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 对javabean类进行转换的工具
 * @Date 2020/7/1 22:13
 * @Author HetFrame
 */
public class BeanUtil {

    private static BeanUtil instance;
    /**
     * 保存不同类之间的复制器
     */
    private final Map<String, BeanCopier> beanCopierMap;

    private BeanUtil() {
        // 私有无参构造器
        beanCopierMap = new HashMap<>();
    }

    public static BeanUtil getInstance() {
        if (instance == null) {
            synchronized (BeanUtil.class) {
                if (instance == null) {
                    instance = new BeanUtil();
                }
            }
        }
        return instance;
    }

    /**
     * @param sourceClass 待转换的资源类
     * @param targetClass 目标类
     * @Description 通过资源类类名和目标类类名生成复制器的key，例如"UserDTO->UserVO"
     * @date 2020/7/2 9:51
     * @return: java.lang.String
     */
    private String generateKey(Class<?> sourceClass, Class<?> targetClass) {
        return sourceClass.getName() + "->" + targetClass.getName();
    }

    /**
     * @param source 资源类
     * @param target 目标类
     * @Description 将资源类相同类型名称的属性复制到目标类，其余属性不复制
     * @date 2020/7/2 9:52
     * @return: void
     */
    public void copyProperties(Object source, Object target) {
        String key = generateKey(source.getClass(), target.getClass());
        BeanCopier beanCopier;
        //map包含两个类转换的key，直接取出返回；否则创建
        if (beanCopierMap.containsKey(key)) {
            beanCopier = beanCopierMap.get(key);
        } else {
            beanCopier = BeanCopier.create(source.getClass(), target.getClass(), false);
            beanCopierMap.put(key, beanCopier);
        }
        beanCopier.copy(source, target, null);
    }
}
