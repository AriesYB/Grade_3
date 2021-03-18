package com.boss.xtrain.util.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.util.Properties;

/**
 * @Description 基于java mail和spring mail api的邮件工具
 * @Date 2020/7/2 10:52
 * @Author HetFrame
 */
public class EmailUtil {
    private static final Logger log = LoggerFactory.getLogger(EmailUtil.class);

    private static EmailUtil instance;
    /**
     * 邮件Sender
     */
    private final JavaMailSenderImpl javaMailSender;

    /**
     * 邮箱配置
     */
    private final String HOST;
    private final int PORT;
    private final String USERNAME;
    private final String PASSWORD;
    private final String ENCODING;
    private final String PERSONAL;

    /**
     * 在构造方法中初始化内容
     */
    private EmailUtil() {
        //获取配置文件
        Properties properties = readConfig();
        HOST = properties.getProperty("host");
        PORT = Integer.parseInt(properties.getProperty("port"));
        USERNAME = properties.getProperty("username");
        PASSWORD = properties.getProperty("password");
        ENCODING = properties.getProperty("encoding");
        PERSONAL = properties.getProperty("personal");
        //设置邮件Sender配置
        javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(HOST);
        javaMailSender.setPort(PORT);
        javaMailSender.setUsername(USERNAME);
        javaMailSender.setPassword(PASSWORD);
        javaMailSender.setDefaultEncoding(ENCODING);
    }

    public static EmailUtil getInstance() {
        if (instance == null) {
            synchronized (EmailUtil.class) {
                if (instance == null) {
                    instance = new EmailUtil();
                }
            }
        }
        return instance;
    }

    /**
     * @param to           收件人邮箱
     * @param subject      主题
     * @param emailMessage 邮件内容
     * @Description 给指定邮箱发送邮件
     * @date 2020/7/2 15:33
     * @return: void
     */
    public void sendMail(String to, String subject, String emailMessage) throws MessagingException, UnsupportedEncodingException {
        sendMail(to, subject, emailMessage, PERSONAL, null);
    }


    /**
     * @param to       收件人邮箱
     * @param subject  主题
     * @param content  邮件内容
     * @param personal 发送人名称
     * @Description 发送邮件
     * @date 2020/7/2 15:56
     * @return: void
     */
    public void sendMail(String to, String subject, String content, String personal, File file) throws UnsupportedEncodingException, MessagingException {
        //创建信息
        MimeMessage message = javaMailSender.createMimeMessage();
        //创建helper，并设置utf-8
        MimeMessageHelper helper = new MimeMessageHelper(message, true, ENCODING);
        //使用helper设置信息内容
        helper.setFrom(USERNAME, personal);
        helper.setSubject(subject);
        helper.setTo(to);
        helper.setText(content);
        //添加附件
        if (file != null) {
            helper.addAttachment(file.getName(), file);
        }
        //使用sender发送
        javaMailSender.send(message);
    }


    /**
     * @param to      收件人邮箱
     * @param subject 主题
     * @param content 邮件内容
     * @param file    附件文件
     * @Description 发送带附件的邮件
     * @date 2020/7/2 16:21
     * @return: void
     */
    public void sendAttachmentMail(String to, String subject, String content, File file) throws MessagingException, UnsupportedEncodingException {
        sendMail(to, subject, content, PERSONAL, file);
    }

    /**
     * @param to       收件人邮箱
     * @param subject  主题
     * @param content  邮件内容
     * @param personal 发送人名称
     * @param file     附件文件
     * @Description 发送带附件的邮件
     * @date 2020/7/2 16:21
     * @return: void
     */
    public void sendAttachmentMail(String to, String subject, String content, String personal, File file) throws MessagingException, UnsupportedEncodingException {
        sendMail(to, subject, content, personal,file);
    }

    /**
     * @Description 读取配置文件
     * @date 2020/7/2 15:18
     * @return: java.util.Properties
     */
    private Properties readConfig() {
        try {
            Properties properties = new Properties();
            // 使用ClassLoader加载properties配置文件生成对应的输入流
            InputStream in = EmailUtil.class.getClassLoader().getResourceAsStream("config/email.properties");
            assert in != null;
            BufferedReader buf = new BufferedReader(new InputStreamReader(in));
            // 使用properties对象加载输入流
            properties.load(buf);
            return properties;
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return new Properties();
    }

}
