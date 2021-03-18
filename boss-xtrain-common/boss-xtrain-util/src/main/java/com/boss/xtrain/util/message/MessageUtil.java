package com.boss.xtrain.util.message;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.SecureRandom;
import java.util.Random;

/**
 * @Description 短信工具
 * @Date 2020/7/2 11:19
 * @Author HetFrame
 */
public class MessageUtil {
    private static final Logger log = LoggerFactory.getLogger(MessageUtil.class);

    private static MessageUtil instance;

    private MessageUtil() {
        // 私有无参构造器
    }

    public static MessageUtil getInstance() {
        if (instance == null) {
            synchronized (MessageUtil.class) {
                if (instance == null) {
                    instance = new MessageUtil();
                }
            }
        }
        return instance;
    }

    /**
     * 调用阿里云短信服务需要的参数
     */
    private static final String REGION_ID = "cn-hangzhou";
    private static final String ACCESS_KEY_ID = "LTAI4FykJQSYEAhDxd1TNX5a";
    private static final String SECRET = "QdaU3YrWVSpkgAKLZJy1MdhXTGNmwk";
    private static final String DOMAIN = "dysmsapi.aliyuncs.com";
    private static final String VERSION = "2017-05-25";
    private static final String ACTION = "SendSms";

    /**
     * 发送的信息签名参数(需要在阿里云修改后审批后才能修改)
     * 签名和模板code
     */
    private static final String SIGN_NAME = "BES博学慎思";
    private static final String TEMPLATE_CODE = "SMS_194900234";

    /**
     * 鉴权参数 初始化客户端
     */
    private final DefaultProfile profile = DefaultProfile.getProfile(REGION_ID, ACCESS_KEY_ID, SECRET);
    private final IAcsClient client = new DefaultAcsClient(profile);

    /**
     * 用于生成随机验证码
     */
    private static final String SYMBOLS = "0123456789";
    private static final Random RANDOM = new SecureRandom();

    /**
     * @param phone    用户手机号码
     * @param authCode 发送的验证码
     * @throws ClientException 发送失败时抛出异常
     * @Description 发送短信，返回响应内容
     * @date 2020/7/2 11:23
     * @return java.lang.boolean
     */
    public boolean sendMessage(String phone, String authCode) throws ClientException {
        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain(DOMAIN);
        request.setSysVersion(VERSION);
        request.setSysAction(ACTION);
        request.putQueryParameter("RegionId", REGION_ID);
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", SIGN_NAME);
        request.putQueryParameter("TemplateCode", TEMPLATE_CODE);
        request.putQueryParameter("TemplateParam", getAuthCodeJsonString(authCode));
        CommonResponse response = client.getCommonResponse(request);
        Gson gson = new Gson();
        MessageResponse data = gson.fromJson(response.getData(),MessageResponse.class);
        log.info("发送消息详情{}",data);
        return "OK".equals(data.getCode());
    }

    /**
     * @Description 获取6位随机验证码
     * @date 2020/7/2 11:55
     * @return: java.lang.String
     */
    public String getAuthCode() {
        char[] nonceChars = new char[6];
        for (int index = 0; index < nonceChars.length; ++index) {
            nonceChars[index] = SYMBOLS.charAt(RANDOM.nextInt(SYMBOLS.length()));
        }
        return new String(nonceChars);
    }

    /**
     * @param authCode 验证码
     * @Description 转化成jsonString
     * @date 2020/7/2 11:55
     * @return: java.lang.String
     */
    private String getAuthCodeJsonString(String authCode) {
        return "{\"code\":\"" + authCode + "\"}";
    }
}
