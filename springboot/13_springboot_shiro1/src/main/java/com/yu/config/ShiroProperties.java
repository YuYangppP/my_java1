package com.yu.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName ShiroProperties.java
 * @Description TODO
 * @Date 2020/4/8 14:53
 */
@ConfigurationProperties(prefix = "shiro")
@Data
public class ShiroProperties {

    private String hashAlogrithName = "md5";

    private Integer hashIterations=2;

    private String loginUrl;

    private String unauthorizedUrl;

    private String [] anonUrls;

    private String  logoutUrl;

    private String [] authcUrls;


}
