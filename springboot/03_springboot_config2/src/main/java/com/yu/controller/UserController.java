package com.yu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName UserController.java
 * @Description TODO
 * @Date 2020/3/30 14:49
 */
@RestController
@RequestMapping("user")
public class UserController {

    @RequestMapping("hello")
    public String hello(){
        return "hello";
    }
}
