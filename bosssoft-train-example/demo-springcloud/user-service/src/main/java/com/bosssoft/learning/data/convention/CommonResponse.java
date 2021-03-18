package com.bosssoft.learning.data.convention;

/**
 * @Description controller返回的响应，发生异常时，code和messages返回异常信息，data返回数据
 * @Date 2020/6/23 14:41
 * @Author HetFrame
 */
public class CommonResponse<T> {
    private String code;
    private String message;
    private T data;

    public CommonResponse() {
    }

    public CommonResponse(T data) {
        this.data = data;
        setCodeAndMessage(CommonResponseCode.SUCCESS);
    }

    public CommonResponse(T data, CommonResponseCode commonResponseCode) {
        this.data = data;
        setCodeAndMessage(commonResponseCode);
    }

    public CommonResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public CommonResponse(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public void setCodeAndMessage(CommonResponseCode commonResponseCode) {
        this.code = commonResponseCode.getCode();
        this.message = commonResponseCode.getMessage();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CommonResponse{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
