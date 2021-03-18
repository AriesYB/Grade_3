package com.bosssoft.learning.filter;

import com.bosssoft.learning.data.convention.CommonResponse;
import com.bosssoft.learning.data.convention.CommonResponseCode;
import com.bosssoft.learning.pojo.vo.UserVO;
import com.bosssoft.learning.util.JsonUtil;
import com.bosssoft.learning.util.JwtUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 登录成功后设置token
 * @Date 2020/6/24 11:22
 * @Author HetFrame
 */
@Component
public class LoginPostFilter extends ZuulFilter {
    private static final Logger log = LoggerFactory.getLogger(LoginPostFilter.class);
    private static final String LOGIN_URI = "/api/user/login";
    private JwtUtil util;

    @Autowired
    public void setJwtUtil(JwtUtil jwtUtil) {
        this.util = jwtUtil;
    }

    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        //需要过滤登录
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        return LOGIN_URI.equals(request.getRequestURI());
    }

    /**
     * @Description 接收登录的response，若登录成功则生成token返回
     * @date 2020/6/24 13:07
     * @return: java.lang.Object
     */
    @Override
    public Object run() {
        try {
            RequestContext context = RequestContext.getCurrentContext();
            InputStream stream = context.getResponseDataStream();
            String body = StreamUtils.copyToString(stream, StandardCharsets.UTF_8);
            CommonResponse<UserVO> commonResponse = JsonUtil.readValue(body, new TypeReference<CommonResponse<UserVO>>() {
            });
            //登录成功
            if (CommonResponseCode.LOGIN_SUCCESS.getCode().equals(commonResponse.getCode())) {
                //使用id和密码作为生成token的依据，并设置过期时间
                HashMap<String, Object> jwtClaims = new HashMap<>();
                jwtClaims.put("id", commonResponse.getData().getId());
                jwtClaims.put("password", commonResponse.getData().getPassword());
                Date expDate = DateTime.now().plusMinutes(30).toDate();
                String token = util.createJwt(expDate, jwtClaims);
                //新的响应和data
                Map<String, Object> newData = new HashMap<>(2);
                newData.put("token", token);
                newData.put("user", commonResponse.getData());
                CommonResponse<Map<String, Object>> newCommonResponse = new CommonResponse<>(newData, CommonResponseCode.LOGIN_SUCCESS);
                //转换成jsonString 设置到响应中,返回给前端
                String jsonString = JsonUtil.convertToJsonString(newCommonResponse);
                context.setResponseBody(jsonString);
                //设置到头部以给权限过滤器使用
                context.addZuulResponseHeader("token", token);
            } else {
                context.setResponseBody(JsonUtil.convertToJsonString(commonResponse));
            }
            context.getResponse().setCharacterEncoding(StandardCharsets.UTF_8.name());
            context.getResponse().setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return null;
    }
}
