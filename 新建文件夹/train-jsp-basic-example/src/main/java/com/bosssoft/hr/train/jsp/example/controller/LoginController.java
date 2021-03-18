package com.bosssoft.hr.train.jsp.example.controller;

import com.bosssoft.hr.train.jsp.example.pojo.User;
import com.bosssoft.hr.train.jsp.example.util.ServiceUtil;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @param
 * @description:
 * @author: Administrator
 * @create: 2020-05-30 10:11
 * @since
 **/
@Slf4j
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            super.doPost(req, resp);
        } catch (ServletException | IOException e) {
            log.error(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            //ajax请求已经登录直接跳转
            PrintWriter out = resp.getWriter();
            if (req.getHeader("x-requested-with") != null && req.getSession(false) != null && req.getSession(false).getAttribute("userCode") != null) {
                out.print("1");
                out.flush();
                out.close();
                return;
            }
            String code = req.getParameter("code");
            String password = req.getParameter("password");
            User user = new User(code, password);
            //返回查询到用户
            User user1 = ServiceUtil.getUserServiceInstance().authentication(user);
            if (user1 != null) {
                req.getSession(true).setAttribute("user", user1);
                out.print("1");
            } else {
                out.print("0");
            }
            out.flush();
            out.close();
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

}
