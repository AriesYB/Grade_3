package com.bosssoft.hr.train.jsp.example.controller;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:
 * @author: Administrator
 * @create: 2020-05-30 11:22
 * @since
 **/
@Slf4j
public class QueryUserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            super.doPost(req, resp);
        } catch (ServletException | IOException e) {
            log.error(e.getMessage());
        }
    }
}
