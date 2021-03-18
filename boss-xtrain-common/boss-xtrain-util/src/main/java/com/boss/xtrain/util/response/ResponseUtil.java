package com.boss.xtrain.util.response;

import com.boss.xtrain.core.data.convention.CommonResponse;

/**
 * @Description 请求响应工具
 * @Date 2020/7/4 9:58
 * @Author HetFrame
 */
public class ResponseUtil {
    private static ResponseUtil instance;

    private ResponseUtil() {
        // 私有无参构造器
    }

    public static ResponseUtil getInstance() {
        if (instance == null) {
            synchronized (ResponseUtil.class) {
                if (instance == null) {
                    instance = new ResponseUtil();
                }
            }
        }
        return instance;
    }

    /**
     * @param commonResponse 响应
     * @Description 设置响应header默认信息
     * @date 2020/7/5 10:24
     * @return: void
     */
    public void setResponseExtendInfo(CommonResponse<?> commonResponse) {
        commonResponse.getHeader().setCode("0.1");
        commonResponse.getHeader().setVersion("0.1");
        commonResponse.getHeader().setMessage("success");
        commonResponse.getHeader().setEncryptFlag(0);
    }

    /**
     * @param commonResponse 响应
     * @Description 设置响应header版本
     * @date 2020/7/5 10:24
     * @return: void
     */
    public void setResponseExtendInfo(CommonResponse<?> commonResponse, String version) {
        commonResponse.getHeader().setVersion(version);
    }

    /**
     * @param commonResponse 响应
     * @Description 设置响应header code和message
     * @date 2020/7/5 10:24
     * @return: void
     */
    public void setResponseExtendInfo(CommonResponse<?> commonResponse, String code, String message) {
        commonResponse.getHeader().setCode(code);
        commonResponse.getHeader().setMessage(message);
    }

    /**
     * @param commonResponse 响应
     * @Description 设置响应header
     * @date 2020/7/5 10:24
     * @return: void
     */
    public void setResponseExtendInfo(CommonResponse<?> commonResponse, String version, String code, String message, Integer encryptFlag) {
        commonResponse.getHeader().setCode(code);
        commonResponse.getHeader().setVersion(version);
        commonResponse.getHeader().setMessage(message);
        commonResponse.getHeader().setEncryptFlag(encryptFlag);
    }


}
