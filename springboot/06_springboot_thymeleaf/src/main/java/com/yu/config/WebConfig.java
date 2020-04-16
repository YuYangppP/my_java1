package com.yu.config;

import com.yu.controller.AppFilter;
import com.yu.controller.AppListener;
import com.yu.controller.UserServlet;
import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName WebConfig.java
 * @Description TODO
 * @Date 2020/4/5 16:31
 */

@Configuration
@Component
@ConfigurationProperties(prefix = "web")
@Data
public class WebConfig {

    private boolean appListenerEnable = true;

    /**
    * 创建UserServlet
    * @Param:
    * @return: 
    * @Author: YuYang
    * @Date: 16:32
    */
    @Bean("userServlet")
    @ConditionalOnClass(value = {UserServlet.class})
    public UserServlet userServlet(){
        return new UserServlet();
    }

    /**
     * 注册UserServlet
     */
    @Bean
    @ConditionalOnBean(value = {UserServlet.class})
    public ServletRegistrationBean<UserServlet> servletServletRegistrationBeanUserServlet(UserServlet userServlet){
        //创建注册器对象
        ServletRegistrationBean<UserServlet> registrationBean = new ServletRegistrationBean<>();
        //注入Servlet
        registrationBean.setServlet(userServlet);
        //设置参数
        registrationBean.addInitParameter("env","UTF-8");
        registrationBean.addInitParameter("hello","你好");

        //设置映射
        registrationBean.addUrlMappings("/user1.action","/user2.action");
        return registrationBean;
    }

    /**
    * 创建Filter
    * @Param: 
    * @return: 
    * @Author: YuYang
    * @Date: 17:00
    */
    @Bean("appFilter")
    @ConditionalOnClass(value = {AppFilter.class})
    public AppFilter appFilter(){
        return new AppFilter();
    }

    /**
     * 注册Filter
     */
    public FilterRegistrationBean<AppFilter> filterFilterRegistrationBean(AppFilter appFilter){
        //创建注册器
        FilterRegistrationBean<AppFilter> registrationBean = new FilterRegistrationBean<>();

        //注入Filter
        registrationBean.setFilter(appFilter);

        //设置参数
        registrationBean.addInitParameter("env","filter-UTF-8");
        registrationBean.addInitParameter("hello","filter-你好");
        //设置映射
        //registrationBean.addUrlPatterns("/*"); //所有servlet都经过此过滤器
        registrationBean.addServletNames("userServlet");
        return registrationBean;
    }


    /**
    * 创建Listener
    * @Param: 
    * @return: 
    * @Author: YuYang
    * @Date: 17:20
    */
    @Bean
    @ConditionalOnClass(value = {AppListener.class})
    public AppListener appListener(){
        return new AppListener();
    }

    /**
     * 注册Listener
     */
    @Bean
    @ConditionalOnBean(value = {AppListener.class})
    public ServletListenerRegistrationBean<AppListener> servletListenerRegistrationBean(AppListener appListener){
        //创建注册器
        ServletListenerRegistrationBean<AppListener> bean = new ServletListenerRegistrationBean<>();

        //注入Listener
        bean.setListener(appListener);
        bean.setEnabled(appListenerEnable);
        return bean;
    }
}
