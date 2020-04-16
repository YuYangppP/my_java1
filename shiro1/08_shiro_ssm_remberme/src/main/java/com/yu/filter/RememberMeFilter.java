package com.yu.filter;

import com.yu.utils.ActiveUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName RememberMeFilter.java
 * @Description TODO
 * @Date 2020/4/12 13:07
 */
public class RememberMeFilter extends FormAuthenticationFilter {

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        //得到主体
        Subject subject = SecurityUtils.getSubject();
        //得到session
        Session session = subject.getSession();
        if(!subject.isAuthenticated()&&subject.isRemembered()&&session.getAttribute("user")==null){
            ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
            session.setAttribute("user",activeUser.getUser());
        }
        return true;
    }
}
