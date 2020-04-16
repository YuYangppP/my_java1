package com.yu.erp.sys.controller;

import com.yu.erp.sys.common.ActiverUser;
import com.yu.erp.sys.common.ResultObj;
import com.yu.erp.sys.common.WebUtils;
import com.yu.erp.sys.domain.Loginfo;
import com.yu.erp.sys.service.LoginfoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName LoginController.java
 * @Description TODO
 * @Date 2020/3/21 14:09
 */
@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private LoginfoService loginfoService;

    @RequestMapping("login")
    public ResultObj login(String loginname, String pwd){
        Subject subject = SecurityUtils.getSubject();
        AuthenticationToken token = new UsernamePasswordToken(loginname,pwd);
        try {
            subject.login(token);
            ActiverUser activerUser = (ActiverUser) subject.getPrincipal();
            WebUtils.getSession().setAttribute("user",activerUser.getUser());

            //记录登录日志
            Loginfo enity = new Loginfo();
            enity.setLoginname(activerUser.getUser().getName()+"-"+activerUser.getUser().getLoginname());
            enity.setLoginip(WebUtils.getRequest().getRemoteAddr());
            enity.setLogintime(new Date());
            loginfoService.save(enity);

            return ResultObj.LOGIN_SUCCESS;
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return ResultObj.LOGIN_ERROR_PASS;
        }

    }
}
