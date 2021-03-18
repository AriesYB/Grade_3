package com.boss.xtrain.util.message;

import com.google.gson.annotations.SerializedName;

/**
 * @Description 调用短信api后的响应
 * @Date 2020/7/2 12:25
 * @Author HetFrame
 */
public class MessageResponse {
    @SerializedName("Message")
    private String message;
    @SerializedName("RequestId")
    private String requestId;
    @SerializedName("BizId")
    private String bizId;
    @SerializedName("Code")
    private String code;

    public MessageResponse() {
    }

    public MessageResponse(String message, String requestId, String bizId, String code) {
        this.message = message;
        this.requestId = requestId;
        this.bizId = bizId;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "\nMessageResponse:\n" +
                "message=\"" + message + "\"\n" +
                "requestId=\"" + requestId + "\"\n" +
                "bizId=\"" + bizId + "\"\n" +
                "code=\"" + code+"\"";
    }
}
