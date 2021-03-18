package com.boss.xtrain.util.email;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.MessagingException;
import java.io.File;
import java.io.UnsupportedEncodingException;

/**
 * @Description TODO
 * @Date 2020/7/2 15:32
 * @Author HetFrame
 */
public class EmailUtilTest {
    private static final Logger log = LoggerFactory.getLogger(EmailUtilTest.class);

    @Test
    public void sendMail() {
        try {
            EmailUtil.getInstance().sendMail("yangbiao@ikanp.top", "测试标题", "这是邮箱内容");
        } catch (MessagingException | UnsupportedEncodingException e) {
            log.error(e.getMessage());
        }
    }

    @Test
    public void sendAttachmentMail() {
        try {
        String path = "src/main/resources/config/email.properties";
        File file = new File(path);
        log.info(String.valueOf(file.exists()));
            EmailUtil.getInstance().sendAttachmentMail("yangbiao@ikanp.top", "测试标题", "这是邮箱内容", file);
        } catch (MessagingException | UnsupportedEncodingException e) {
            log.error(e.getMessage());
        }
    }
}