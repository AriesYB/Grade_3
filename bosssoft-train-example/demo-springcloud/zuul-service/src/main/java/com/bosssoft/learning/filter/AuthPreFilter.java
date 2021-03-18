package com.bosssoft.learning.filter;

import com.bosssoft.learning.data.convention.CommonResponse;
import com.bosssoft.learning.data.convention.CommonResponseCode;
import com.bosssoft.learning.util.JsonUtil;
import com.bosssoft.learning.util.JwtUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;


/**
 * @Description 权限验证过滤器
 * @Date 2020/6/23 23:44
 * @Author HetFrame
 */
@Component
public class AuthPreFilter extends ZuulFilter {

    private static final Logger log = LoggerFactory.getLogger(AuthPreFilter.class);
    private static final String LOGIN_URI = "/api/user/login";
    private JwtUtil util;

    @Autowired
    public void setJwtUtil(JwtUtil jwtUtil) {
        this.util = jwtUtil;
    }

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        //除了登录都进行过滤
        return !LOGIN_URI.equals(request.getRequestURI());
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        HttpServletResponse response = context.getResponse();
        //从头部获取token
        String token = request.getHeader("token");
        Claims claims;
        try {
            //解析没有异常则表示token验证通过
            claims = util.parseJwt(token);
            log.info("token : {} 验证通过", token);
            //对请求进行路由
            context.setSendZuulResponse(true);
            //请求头加入userId，传给业务服务
            context.addZuulRequestHeader("id", claims.get("id").toString());
        } catch (ExpiredJwtException expiredJwtEx) {
            log.error("token : {} 过期", token);
            //不对请求进行路由
            context.setSendZuulResponse(false);
            //创建响应内容设置信息为过期
            CommonResponse<String> responseContent = new CommonResponse<>();
            responseContent.setCodeAndMessage(CommonResponseCode.TOKEN_EXPIRED);
            context.setResponseBody(JsonUtil.convertToJsonString(responseContent));
            response.setCharacterEncoding(StandardCharsets.UTF_8.name());
            response.setContentType("application/json;charset=utf-8");
        } catch (Exception e) {
            log.error("token : {} 验证失败", token);
            //不对请求进行路由
            context.setSendZuulResponse(false);
            CommonResponse<String> responseContent = new CommonResponse<>();
            responseContent.setCodeAndMessage(CommonResponseCode.TOKEN_INVALID);
            context.setResponseBody(JsonUtil.convertToJsonString(responseContent));
            response.setCharacterEncoding(StandardCharsets.UTF_8.name());
            response.setContentType("application/json;charset=utf-8");
        }

        return null;
    }
}
