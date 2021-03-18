package com.bosssoft.learning.lock.impl;

import com.bosssoft.learning.lock.DistributionLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Description redis分布式锁实现
 * @Date 2020/6/20 16:02
 * @Author HetFrame
 */
@Component
public class DistributionLockImpl implements DistributionLock {
    private StringRedisTemplate template;

    @Autowired
    public void setTemplate(StringRedisTemplate template) {
        this.template = template;
    }

    private static final String LOCK_KEY = "lock";

    @Override
    public boolean lock() {
        return Boolean.TRUE.equals(template.opsForValue().setIfAbsent(LOCK_KEY, "1", 3 * 60L, TimeUnit.SECONDS));
    }

    @Override
    public boolean release() {
        return Boolean.TRUE.equals(template.delete(LOCK_KEY));
    }
}
