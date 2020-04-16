package com.yu.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName Swagger2AutoConfiguration.java
 * @Description TODO
 * @Date 2020/4/8 11:52
 */
@Configuration
@EnableSwagger2
public class Swagger2AutoConfiguration {

    @Bean
    public Docket swaggerSpringMvcPlugin() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                //.apis(RequestHandlerSelectors.withClassAnnotation(ApiOperation.class))
                //.apis(RequestHandlerSelectors.basePackage("com.yu.controller"))
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().description("这是一个很NB的API工具")
                .contact(new Contact("鱼", "http://leige.tech", "78414842@qq.com"))  //名片
                .version("1.0")  //版本
                .license("yu")//所有者
                .build();//构造
    }
}
