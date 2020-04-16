package com.yu.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.yu.inteceptor.MyInteceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * @program: 0812springboot
 * @author: 雷哥
 * @create: 2019-12-17 09:22
 **/
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //index/hello --->IndexController--->templates/hello.html
//        registry.addRedirectViewController();//重定向

        //请求转发
        registry.addViewController("/index/hello")
                .setViewName("hello");

        //请求重定向
        registry.addRedirectViewController("/index/userlist","/userlist.html");


        registry.addRedirectViewController("/index/listx","/index/list");


        //请求转发
        registry.addViewController("/index/list")
                .setViewName("list");

    }


    /**
     * 自定义格式化器
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new Formatter<Date>() {
            /**
             *
             * @param text  代表页面传过来的字符串
             * @param locale
             * @return
             * @throws ParseException
             */
            @Override
            public Date parse(String text, Locale locale) throws ParseException {
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                return sdf.parse(text);
            }

            @Override
            public String print(Date object, Locale locale) {
                return null;
            }
        });

    }


    /**
     * 自定义扩展消息转化器[平时不配，因为有jaskson的转化器]
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter fc=new FastJsonHttpMessageConverter();
        FastJsonConfig config=new FastJsonConfig();
        config.setSerializerFeatures(SerializerFeature.PrettyFormat);
        fc.setFastJsonConfig(config);
        converters.add(fc);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        MyInteceptor myInteceptor = new MyInteceptor();
        registry.addInterceptor(myInteceptor).addPathPatterns("/**")    //拦截路径，可以配置多个
                .excludePathPatterns("/index/addUser1*");   //放行路径，可以配置多个
    }
}
