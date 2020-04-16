package com.yu.exception;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName AppExceptionAdvice.java
 * @Description TODO
 * @Date 2020/4/12 13:58
 */
@RestControllerAdvice
public class AppExceptionAdvice {

    @ExceptionHandler(value = {UnauthorizedException.class})
    public Map<String,Object> unAuthorized(){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("code",-1);
        map.put("msg","未授权");
        return map;
    }
}
