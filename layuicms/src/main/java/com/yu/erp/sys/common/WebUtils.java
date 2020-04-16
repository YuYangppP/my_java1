package com.yu.erp.sys.common;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName WebUtils.java
 * @Description TODO
 * @Date 2020/3/21 14:21
 */
public class WebUtils {
    /**
     * 得到Request
     */

    public static HttpServletRequest getRequest(){
         ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        return request;
    }

    /**
     * 得到Session
     * @return
     */
    public static HttpSession getSession(){

        return getRequest().getSession();
    }

}
