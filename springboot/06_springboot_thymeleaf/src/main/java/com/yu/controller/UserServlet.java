package com.yu.controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName UserServlet.java
 * @Description TODO
 * @Date 2020/4/5 16:26
 */
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("hello--UserServlet");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        String env = config.getInitParameter("env");
        String hello = config.getInitParameter("hello");
        System.out.println(env+" "+hello);

    }
}
