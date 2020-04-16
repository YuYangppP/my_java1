package com.yu.springbootthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName FirstController.java
 * @Description TODO
 * @Date 2019/12/17 15:49
 */
@Controller
public class FirstController {
    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        return "Hello World";
    }
}
