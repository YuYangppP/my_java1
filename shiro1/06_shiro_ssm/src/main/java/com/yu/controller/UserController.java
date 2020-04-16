package com.yu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName UserController.java
 * @Description TODO
 * @Date 2020/4/11 22:23
 */
@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping("loadAllUser")
    public String loadAllUser(){
        return "list";
    }
}
