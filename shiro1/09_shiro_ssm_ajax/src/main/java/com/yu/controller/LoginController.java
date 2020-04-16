package com.yu.controller;

import com.yu.utils.ActiveUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

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
    @RequestMapping("toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("login")
    @ResponseBody
    public Map<String,Object> login(String username, String password, HttpSession session){
        Map<String, Object> map = new HashMap<String, Object>();
        //1.得到主体
        Subject subject = SecurityUtils.getSubject();
        //2.封装用户名和密码
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
            ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
            session.setAttribute("user",activeUser.getUser());
            map.put("code",0);
            map.put("msg","认证通过");
            return map;
        } catch (AuthenticationException e) {
            System.out.println("用户名或密码不正确");
        }
        map.put("code",-1);
        map.put("msg","认证失败");
        return map;    }
}
