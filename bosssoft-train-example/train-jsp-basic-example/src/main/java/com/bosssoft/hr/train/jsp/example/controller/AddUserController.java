package com.bosssoft.hr.train.jsp.example.controller;

import com.bosssoft.hr.train.jsp.example.pojo.User;
import com.bosssoft.hr.train.jsp.example.util.ServiceUtil;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @param
 * @description:
 * @author: Administrator
 * @create: 2020-05-30 11:21
 * @since
 **/
@Slf4j
public class AddUserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {

            int id = Integer.parseInt(req.getParameter("id"));
            String code = req.getParameter("code");
            String name = req.getParameter("name");
            String password = req.getParameter("password");
            User user = new User(id, name, code, password);
            boolean flag = ServiceUtil.getUserServiceInstance().save(user);
            PrintWriter out = resp.getWriter();
            if (flag) {
                List<User> others = (List<User>) this.getServletContext().getAttribute("others");
                others.add(user);
                out.print("1");
            } else {
                out.print("0");
            }
            out.flush();
            out.close();
        } catch (IOException|NumberFormatException e) {
            log.error(e.getMessage());
        }
    }
}
