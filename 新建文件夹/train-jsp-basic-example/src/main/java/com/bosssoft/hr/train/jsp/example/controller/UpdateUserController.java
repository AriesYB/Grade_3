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
import java.util.List;

/**
 * @description:
 * @author: Administrator
 * @create: 2020-05-30 11:22
 * @since
 **/
@Slf4j
public class UpdateUserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)  {
        try {
        int id = Integer.parseInt(req.getParameter("id"));
        String code = req.getParameter("code");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        boolean flag = ServiceUtil.getUserServiceInstance().update(new User(id, name, code, password));
        PrintWriter out = null;
            out = resp.getWriter();
        if (flag) {
            List<User> others = (List<User>) this.getServletContext().getAttribute("others");
            for (int i = 0; i < others.size(); i++) {
                User user = others.get(i);
                if (user.getId() == id) {
                    user.setName(name);
                    user.setPassword(password);
                }
            }
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
