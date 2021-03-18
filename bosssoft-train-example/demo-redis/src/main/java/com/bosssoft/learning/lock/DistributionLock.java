package com.bosssoft.learning.lock;

/**
 * @Description 分布式锁
 * @Date 2020/6/20 15:59
 * @Author HetFrame
 */
public interface DistributionLock {
    boolean lock();
    boolean release();
}
