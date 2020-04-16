package com.yu.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName AppListener.java
 * @Description TODO
 * @Date 2020/4/11 22:09
 */
@WebListener
public class AppListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        context.setAttribute("ctx",context.getContextPath());
    }

    public void contextDestroyed(ServletContextEvent sce) {

    }
}
