package com.bosssoft.hr.train.jsp.example.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description 过滤器 用于设置字符编码等
 * @Date 2020/6/3 10:44
 * @Author HetFrame
 */
public class UserFilter implements Filter {
    FilterConfig config = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        // 获取web.xml设置的编码集，设置到Request、Response中
        request.setCharacterEncoding(config.getInitParameter("charset"));
        response.setContentType(config.getInitParameter("contentType"));
        response.setCharacterEncoding(config.getInitParameter("charset"));
        // 将请求转发到目的地
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // destroy
    }
}
