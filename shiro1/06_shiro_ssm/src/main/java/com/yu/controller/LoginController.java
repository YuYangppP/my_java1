package com.yu.controller;

import com.yu.utils.ActiveUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName LoginController.java
 * @Description TODO
 * @Date 2020/4/11 22:12
 */
@Controller
@RequestMapping("login")
public class LoginController {

    /**
     * 跳转到登陆页面
     */
    @RequestMapping("toLogin")
    public String toLogin(){
        return "login";
    }

    /**
     * 完成登录的方法
     */
    @RequestMapping("login")
    public String login(String username, String password, HttpSession session){
        //1.得到主体
        Subject subject = SecurityUtils.getSubject();
        //2.封装用户名和密码
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
            ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
            session.setAttribute("user",activeUser.getUser());
            return "redirect:/user/loadAllUser.action";
        } catch (AuthenticationException e) {
            System.out.println("用户名或密码不正确");

        }
        return "redirect:index.jsp";
    }
}
