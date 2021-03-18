package com.bosssoft.learning.service.impl;

import com.bosssoft.learning.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @Description 实现类
 * @Date 2020/6/11 18:32
 * @Author HetFrame
 */
@Service
public class EmailServiceImpl implements EmailService {

    private static final String EMAIL = "1678335192@qq.com";
    private static final Logger log = LoggerFactory.getLogger(EmailServiceImpl.class);

    private JavaMailSender javaMailSender;

    @Autowired
    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    @Scheduled(cron = "* */30 * * * ?")
    public void sendEmail() {
        log.info("即将发送邮件...");
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(EMAIL);
        simpleMailMessage.setTo("yangbiao@ikanp.top");
        simpleMailMessage.setSubject("定时任务测试");
        simpleMailMessage.setText("----定时邮箱----");
        try {
            javaMailSender.send(simpleMailMessage);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
