package com.bosssoft.hr.train.jsp.example.listener;

import com.bosssoft.hr.train.jsp.example.pojo.User;
import com.bosssoft.hr.train.jsp.example.util.ServiceUtil;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description ServletContext中添加List<User>
 * @Date 2020/6/3 11:00
 * @Author HetFrame
 */
@Slf4j
public class UserListener implements HttpSessionListener, HttpSessionAttributeListener, ServletContextListener {

    private static final String USERS = "users";
    private static final String OTHERS = "others";

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        //用户登录
        User user = (User) se.getSession().getAttribute("user");
        log.info("session添加属性userCode:" + user);
        List<User> users = (List<User>) se.getSession().getServletContext().getAttribute(USERS);
        List<User> others = (List<User>) se.getSession().getServletContext().getAttribute(OTHERS);
        if (users == null) {
            users = new ArrayList<>();
            se.getSession().getServletContext().setAttribute(USERS, users);
        }
        users.add(user);
        others.remove(user);
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
// NO
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
// NO
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // NO
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        User user = (User) se.getSession().getAttribute(USERS);
        log.info("session销毁,userCode:" + user);
        List<User> users = (List<User>) se.getSession().getServletContext().getAttribute(USERS);
        List<User> others = (List<User>) se.getSession().getServletContext().getAttribute(OTHERS);
        users.remove(user);
        others.add(user);
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        List<User> others = ServiceUtil.getUserServiceInstance().listAll();
        sce.getServletContext().setAttribute(OTHERS, others);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // NO
    }
}
