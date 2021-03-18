package com.boss.xtrain.util.message;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description 测试短信工具
 * @Date 2020/7/2 11:58
 * @Author HetFrame
 */
public class MessageUtilTest {
    private static final Logger log = LoggerFactory.getLogger(MessageUtilTest.class);

    @Test
    public void sendMessage() {
//        try {
        String code = MessageUtil.getInstance().getAuthCode();
        log.info("获取到的验证码:{}", code);
//            boolean flag =MessageUtil.getInstance().sendMessage("13940237389", code);
//            log.info("调用是否成功:{}",flag);
//        } catch (ClientException e) {
//            log.error(e.getMessage());
//        }
    }

    @Test
    public void getAuthCode() {
        for (int i = 0; i < 10; i++) {
            log.info("测试获取验证码:{}", MessageUtil.getInstance().getAuthCode());
        }
    }
}