package com.yu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName ShiroAutoConfiguration.java
 * @Description TODO
 * @Date 2020/4/8 14:52
 */
@Configuration
@EnableConfigurationProperties(ShiroProperties.class)
public class ShiroAutoConfiguration {

    @Autowired
    private ShiroProperties shiroProperties;


    

}
