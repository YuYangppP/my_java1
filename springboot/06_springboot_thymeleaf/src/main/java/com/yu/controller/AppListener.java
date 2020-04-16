package com.yu.controller;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName AppListener.java
 * @Description TODO
 * @Date 2020/4/5 17:16
 */
public class AppListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("contextInitialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
