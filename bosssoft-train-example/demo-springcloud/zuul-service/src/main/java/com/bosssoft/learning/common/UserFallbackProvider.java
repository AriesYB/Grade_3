package com.bosssoft.learning.common;

import com.bosssoft.learning.data.convention.CommonResponse;
import com.bosssoft.learning.data.convention.CommonResponseCode;
import com.bosssoft.learning.pojo.vo.UserVO;
import com.bosssoft.learning.util.JsonUtil;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/**
 * @Description 熔断器
 * @Date 2020/6/24 22:09
 * @Author HetFrame
 */
@Component
public class UserFallbackProvider implements FallbackProvider {
    public static final String BODY = "fallback";

    @Override
    public String getRoute() {
        //指定具体的路由服务 *表示全部
        return "*";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return 200;
            }

            @Override
            public String getStatusText() throws IOException {
                return null;
            }

            @Override
            public void close() {
                // Nothing
            }

            @Override
            public InputStream getBody() {
                //确保返回的格式与正常请求一致
                return new ByteArrayInputStream(Objects.requireNonNull(JsonUtil.convertToJsonString(new CommonResponse<UserVO>(null, CommonResponseCode.SERVICE_UNAVAILABLE))).getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        };
    }
}
