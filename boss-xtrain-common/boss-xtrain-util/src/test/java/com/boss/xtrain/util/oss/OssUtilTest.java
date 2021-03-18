package com.boss.xtrain.util.oss;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * @Description 测试对象存储
 * @Date 2020/7/2 22:49
 * @Author HetFrame
 */
public class OssUtilTest {

    private static final Logger log = LoggerFactory.getLogger(OssUtilTest.class);

    @Test
    public void uploadFile() {
        OssUtil.getInstance().uploadFile("testFile", "src/test/java/com/boss/xtrain/util/oss/test.txt");
        OssUtil.getInstance().deleteFile("testFile");
    }

    @Test
    public void getFileUrl() {
        InputStream is = null;
        try {
            URL url = OssUtil.getInstance().getFileUrl("readme.txt");
            is = url.openStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            StringBuilder sb = new StringBuilder();
            int cp;
            while ((cp = rd.read()) != -1) {
                sb.append((char) cp);
            }
            log.info("Url:{}", url);
            log.info("通过url读取到的内容:{}", sb);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void uploadFileBySign() {
        try {
            log.info("参数内容:{}", OssUtil.getInstance().uploadFileBySign());
        } catch (UnsupportedEncodingException e) {
            log.error(e.getMessage());
        }
    }
}