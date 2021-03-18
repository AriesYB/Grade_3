package com.example.callbackserver.controller;

import com.example.callbackserver.bean.OssBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 客户端上传OSS，然后回调此controller
 * @Date 2020/7/3 0:20
 * @Author HetFrame
 */
@Slf4j
@RestController
public class CallbackController {

    @PostMapping("/callback")
    public Map<String,String> callback(HttpServletRequest request, OssBody ossBody) {
        log.info("OSS回调。");
        log.info("Authorization:{}", request.getHeader("Authorization"));
        log.info("publicKey:{}", request.getHeader("x-oss-pub-key-url"));
        log.info("响应的内容:{}", ossBody);
        Map<String,String> map = new HashMap<>();
        map.put("Status","OK");
        return map;
    }

    @GetMapping("/test")
    public String testUpload(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST");
//        try {
//            return OssUtil.getInstance().uploadFileBySign("yangbiao");
//        } catch (UnsupportedEncodingException e) {
//            log.error(e.getMessage());
//        }
        return "{\"accessid\":\"LTAI4FykJQSYEAhDxd1TNX5a\",\"policy\":\"eyJleHBpcmF0aW9uIjoiMjAyMC0wNy0wM1QwMzo1OTozMC44MjVaIiwiY29uZGl0aW9ucyI6W1siY29udGVudC1sZW5ndGgtcmFuZ2UiLDAsMTA0ODU3NjAwMF0sWyJzdGFydHMtd2l0aCIsIiRrZXkiLCJpbWFnZXMvIl1dfQ==\",\"signature\":\"c0uBATdFjpwhuXWSnHczIWWpaqY=\",\"dir\":\"images/\",\"host\":\"http://alioss.ikanp.top\",\"expire\":\"1593748770\",\"callback\":\"eyJjYWxsYmFja1VybCI6Imh0dHA6Ly9pa2FucC50b3A6ODAwOC9jYWxsYmFjayIsImNhbGxiYWNrQm9keSI6ImZpbGVuYW1lPSR7b2JqZWN0fSZzaXplPSR7c2l6ZX0mbWltZVR5cGU9JHttaW1lVHlwZX0maGVpZ2h0PSR7aW1hZ2VJbmZvLmhlaWdodH0md2lkdGg9JHtpbWFnZUluZm8ud2lkdGh9IiwiY2FsbGJhY2tCb2R5VHlwZSI6ImFwcGxpY2F0aW9uL3gtd3d3LWZvcm0tdXJsZW5jb2RlZCJ9\"}";
    }

}
