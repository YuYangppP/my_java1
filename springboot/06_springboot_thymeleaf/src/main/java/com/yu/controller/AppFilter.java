package com.yu.controller;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName AppFilter.java
 * @Description TODO
 * @Date 2020/4/5 16:58
 */
public class AppFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String env = filterConfig.getInitParameter("env");
        String hello = filterConfig.getInitParameter("hello");
        System.out.println(env+"  "+hello);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
