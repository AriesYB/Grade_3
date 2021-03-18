package com.example.callbackserver.bean;

import java.io.Serializable;

/**
 * @Description OSS回调返回的数据
 * @Date 2020/7/3 8:36
 * @Author HetFrame
 */
public class OssBody implements Serializable {
    private String filename;
    private String size;
    private String mineType;
    private String height;

    public OssBody() {
    }

    public OssBody(String filename, String size, String mineType, String height) {
        this.filename = filename;
        this.size = size;
        this.mineType = mineType;
        this.height = height;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMineType() {
        return mineType;
    }

    public void setMineType(String mineType) {
        this.mineType = mineType;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "OssBody{" +
                "filename='" + filename + '\'' +
                ", size='" + size + '\'' +
                ", mineType='" + mineType + '\'' +
                ", height='" + height + '\'' +
                '}';
    }
}
