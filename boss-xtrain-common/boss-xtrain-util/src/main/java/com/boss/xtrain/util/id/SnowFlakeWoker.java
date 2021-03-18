package com.boss.xtrain.util.id;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description 基于雪花算法生成分布式唯一id
 * id结构：正负-时间戳-工作机器-序列号
 * 正负：默认为0，0表示正，1表示负，1bit
 * 时间戳：41bit
 * 工作机器：10bit
 * 序列号：12bit
 * 生成的id共64bit，需要使用long类型
 * @Date 2020/7/3 21:17
 * @Author HetFrame
 */
public class SnowFlakeWoker {

    private static final Logger log = LoggerFactory.getLogger(SnowFlakeWoker.class);

    private static SnowFlakeWoker instance;

    public static SnowFlakeWoker getInstance(){
        if (instance == null) {
            synchronized (SnowFlakeWoker.class) {
                if (instance == null) {
                    instance = new SnowFlakeWoker(00000,00000,00000000000);
                }
            }
        }
        return instance;
    }

    /**
     * 5位工作ID
     */
    private long workerId;
    /**
     * 5位数据ID
     */
    private long datacenterId;
    /**
     * 12位序列号
     */
    private long sequence;

    private SnowFlakeWoker(long workerId, long datacenterId, long sequence) {
        // sanity check for workerId
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(String.format("工作ID不能超过%d或者小于0", maxWorkerId));
        }
        if (datacenterId > maxDatacenterId || datacenterId < 0) {
            throw new IllegalArgumentException(String.format("数据ID不能超过%d或者小于0", maxDatacenterId));
        }
        log.info("开始生成,时间戳:{},数据ID:{},工作ID:{},序列号:{},工作ID:{}", timestampLeftShift, datacenterIdBits, workerIdBits, sequenceBits, workerId);
        this.workerId = workerId;
        this.datacenterId = datacenterId;
        this.sequence = sequence;
    }

    /**
     * 初始时间戳
     */
    private long twepoch = 1288834974657L;

    /**
     * 长度为5位
     */
    private final long workerIdBits = 5L;
    private final long datacenterIdBits = 5L;
    /**
     * 最大值
     */
    private final long maxWorkerId = ~(-1L << workerIdBits);
    private final long maxDatacenterId = ~(-1L << datacenterIdBits);
    /**
     * 序列号id长度
     */
    private final long sequenceBits = 12L;
    /**
     * 序列号最大值
     */
    private final long sequenceMask = ~(-1L << sequenceBits);

    /**
     * 工作id需要左移的位数，12位
     */
    private final long workerIdShift = sequenceBits;
    /**
     * 数据id需要左移位数 12+5=17位
     */
    private final long datacenterIdShift = sequenceBits + workerIdBits;
    /**
     * 时间戳需要左移位数 12+5+5=22位
     */
    private final long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;
    /**
     * 上次时间戳，初始值为负数
     */
    private long lastTimestamp = -1L;

    public long getWorkerId() {
        return workerId;
    }

    public long getDatacenterId() {
        return datacenterId;
    }

    public long getTimestamp() {
        return System.currentTimeMillis();
    }


    /**
     * @Description 下一个ID生成算法
     * @date 2020/7/4 9:44
     * @return: long
     */
    public synchronized long nextId() {
        long timestamp = timeGen();

        //获取当前时间戳如果小于上次时间戳，则表示时间戳获取出现异常
        if (timestamp < lastTimestamp) {
            log.error("当前时间戳:{}早于上次时间戳:{}", timestamp, lastTimestamp);
            throw new IdErrorException(String.format("时间倒退。请等待%d毫秒",
                    lastTimestamp - timestamp));
        }

        //获取当前时间戳如果等于上次时间戳（同一毫秒内），则在序列号加一；否则序列号赋值为0，从0开始。
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0;
        }

        //将上次时间戳值刷新
        lastTimestamp = timestamp;

        /**
         * 返回结果：
         * (timestamp - twepoch) << timestampLeftShift) 表示将时间戳减去初始时间戳，再左移相应位数
         * (datacenterId << datacenterIdShift) 表示将数据id左移相应位数
         * (workerId << workerIdShift) 表示将工作id左移相应位数
         * | 是按位或运算符，例如：x | y，只有当x，y都为0的时候结果才为0，其它情况结果都为1。
         * 因为个部分只有相应位上的值有意义，其它位上都是0，所以将各部分的值进行 | 运算就能得到最终拼接好的id
         */
        return ((timestamp - twepoch) << timestampLeftShift) |
                (datacenterId << datacenterIdShift) |
                (workerId << workerIdShift) |
                sequence;
    }

    //获取时间戳，并与上次时间戳比较
    private long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    //获取系统时间戳
    private long timeGen() {
        return System.currentTimeMillis();
    }

}
