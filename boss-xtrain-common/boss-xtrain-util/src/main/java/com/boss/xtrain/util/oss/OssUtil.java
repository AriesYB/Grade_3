package com.boss.xtrain.util.oss;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;
import com.aliyun.oss.model.PutObjectRequest;
import net.sf.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description 对象存储，上传文件建议使用签名返回让前端上传
 * @Date 2020/7/2 20:55
 * @Author HetFrame
 */
public class OssUtil {
    private static OssUtil instance;

    private OssUtil() {
    }

    public static OssUtil getInstance() {
        if (instance == null) {
            synchronized (OssUtil.class) {
                if (instance == null) {
                    instance = new OssUtil();
                }
            }
        }
        return instance;
    }

    /**
     * 访问阿里云对象存储必要的配置参数
     */
    private static final String ENDPOINT = "oss-cn-beijing.aliyuncs.com";
    private static final String ACCESS_KEY_ID = "LTAI4FykJQSYEAhDxd1TNX5a";
    private static final String SECRET = "QdaU3YrWVSpkgAKLZJy1MdhXTGNmwk";
    private static final String BUCKET_NAME = "bes-bucket";
    /**
     * OSSClient实例，用于访问对象存储空间
     */
    private OSS ossClient;

    /**
     * @param name 上传的名称
     * @param path 文件路径
     * @Description 上传文件流到存储空间
     * @date 2020/7/2 21:19
     * @return: void
     */
    public void uploadFileStream(String name, String path) throws FileNotFoundException {
        createClient();
        // 上传文件流
        InputStream inputStream = new FileInputStream(path);
        ossClient.putObject(BUCKET_NAME, name, inputStream);
        closeClient();
    }

    /**
     * @param path 文件路径
     * @Description 上传文件
     * @date 2020/7/2 21:30
     * @return: void
     */
    public void uploadFile(String name, String path) {
        createClient();
        // 创建PutObjectRequest对象。
        PutObjectRequest putObjectRequest = new PutObjectRequest(BUCKET_NAME, name, new File(path));
        // 上传文件
        ossClient.putObject(putObjectRequest);
        closeClient();
    }

    /**
     * @param name 存储的name
     * @Description 删除文件
     * @date 2020/7/2 22:27
     * @return: void
     */
    public void deleteFile(String name) {
        createClient();
        // 删除文件。如需删除文件夹，请将ObjectName设置为对应的文件夹名称。如果文件夹非空，则需要将文件夹下的所有object删除后才能删除该文件夹。
        ossClient.deleteObject(BUCKET_NAME, name);
        closeClient();
    }

    /**
     * @param name 对象name
     * @Description 通过对象name获取文件链接
     * @date 2020/7/2 22:21
     * @return: java.lang.String
     */
    public URL getFileUrl(String name) {
        createClient();
        // 设置URL过期时间为30分钟。
        Date expiration = new Date(System.currentTimeMillis() + 30 * 60 * 1000);
        // 生成以GET方法访问的签名URL，访客可以直接通过浏览器访问相关内容。
        URL url = ossClient.generatePresignedUrl(BUCKET_NAME, name, expiration);
        closeClient();
        return url;
    }

    /**
     * @Description 签名返回policy然后让前端上传至OSS并回调一个方法返回文件信息
     * @date 2020/7/2 23:45
     * @return: OssParam返回给前端的参数，用于直接上传文件
     */

    public String uploadFileBySign() throws UnsupportedEncodingException {
        createClient();
        String host = "http://alioss.ikanp.top";
        // callbackUrl为上传回调服务器的URL，请将下面的IP和Port配置为您自己的真实信息。
        String callbackUrl = "http://ikanp.top:8008/callback";
        // 用户上传文件时指定的前缀。
        String dir = "images/";

        // 设置URL过期时间为5分钟。
        long expirationEndTime = System.currentTimeMillis() + 5 * 60 * 1000;
        Date expiration = new Date(expirationEndTime);

        //设置policy
        PolicyConditions policyConds = new PolicyConditions();
        policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, 1048576000);
        policyConds.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, dir);

        String postPolicy = ossClient.generatePostPolicy(expiration, policyConds);
        byte[] binaryData = postPolicy.getBytes(StandardCharsets.UTF_8);
        //base64加密
        String encodedPolicy = BinaryUtil.toBase64String(binaryData);
        String postSignature = ossClient.calculatePostSignature(postPolicy);

        //开始封装并创建jsonString
        Map<String, String> responseMap = new LinkedHashMap<>();
        responseMap.put("accessid", ACCESS_KEY_ID);
        responseMap.put("policy", encodedPolicy);
        responseMap.put("signature", postSignature);
        responseMap.put("dir", dir);
        responseMap.put("host", host);
        responseMap.put("expire", String.valueOf(expirationEndTime / 1000));

        JSONObject jsonCallback = new JSONObject();
        jsonCallback.put("callbackUrl", callbackUrl);
        jsonCallback.put("callbackBody",
                "filename=${object}&size=${size}&mimeType=${mimeType}&height=${imageInfo.height}&width=${imageInfo.width}");
        jsonCallback.put("callbackBodyType", "application/x-www-form-urlencoded");
        //base64加密回调参数
        String base64CallbackBody = BinaryUtil.toBase64String(jsonCallback.toString().getBytes());
        responseMap.put("callback", base64CallbackBody);
        closeClient();
        return JSONObject.fromObject(responseMap).toString();
    }

    /**
     * @Description 创建客户端
     * @date 2020/7/2 21:22
     * @return: void
     */
    private void createClient() {
        ossClient = new OSSClientBuilder().build(ENDPOINT, ACCESS_KEY_ID, SECRET);
    }

    /**
     * @Description 关闭客户端
     * @date 2020/7/2 21:14
     * @return: void
     */
    private void closeClient() {
        // 关闭OSSClient。
        ossClient.shutdown();
    }

}
