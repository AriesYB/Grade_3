package com.bosssoft.learning.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description java对象转换json字符串
 * @Date 2020/6/24 10:30
 * @Author HetFrame
 */
public class JsonUtil {
    private static final Logger log = LoggerFactory.getLogger(JsonUtil.class);
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private JsonUtil() {
        // 无参构造器
    }

    public static String convertToJsonString(Object o) {
        try {
            return OBJECT_MAPPER.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
        }
        return null;
    }

    /**
     * @param string
     * @param reference
     * @Description 解析json返回对应类型的对象
     * @date 2020/6/24 13:04
     * @return: T
     */
    public static <T> T readValue(String string, TypeReference<T> reference) throws JsonProcessingException {
        return OBJECT_MAPPER.readValue(string, reference);
    }
}
