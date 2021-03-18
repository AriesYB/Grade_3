package com.boss.xtrain.util.id;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description TODO
 * @Date 2020/7/6 9:55
 * @Author HetFrame
 */
public class SnowFlakeWokerTest {

    private static final Logger log = LoggerFactory.getLogger(SnowFlakeWokerTest.class);

    @Test
    public void getWorkerId() {
        log.info("工作ID:{}",SnowFlakeWoker.getInstance().getWorkerId());
    }

    @Test
    public void getDatacenterId() {
        log.info("数据ID:{}",SnowFlakeWoker.getInstance().getDatacenterId());
    }

    @Test
    public void getTimestamp() {
        log.info("时间戳1:{}",SnowFlakeWoker.getInstance().getTimestamp());
        log.info("时间戳2:{}",SnowFlakeWoker.getInstance().getTimestamp());
        log.info("时间戳3:{}",SnowFlakeWoker.getInstance().getTimestamp());
    }

    @Test
    public void nextId() {
        log.info("ID1:{}",SnowFlakeWoker.getInstance().nextId());
        log.info("ID2:{}",SnowFlakeWoker.getInstance().nextId());
        log.info("ID3:{}",SnowFlakeWoker.getInstance().nextId());
    }
}