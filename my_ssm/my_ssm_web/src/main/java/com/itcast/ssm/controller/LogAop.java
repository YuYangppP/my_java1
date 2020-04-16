package com.itcast.ssm.controller;

import com.itcast.ssm.domain.SysLog;
import com.itcast.ssm.service.ISysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author:yuyang
 * @data:2019-05-17 22:21
 **/
@Component
@Aspect
public class LogAop {

    @Autowired
    private ISysLogService sysLogService;

    @Autowired
    private HttpServletRequest request;

    private Date visitTime; //开始时间
    private Class clazz; //访问的类
    private Method method; //访问的方法

    //前置通知
    @Before("execution(* com.itcast.ssm.controller.*.*(..))")
    public void doBefore(JoinPoint jp)throws NoSuchMethodException{
        visitTime = new Date(); //开始访问的时间
        clazz = jp.getTarget().getClass(); //获取当前的访问的类的对象
        String methodName = jp.getSignature().getName(); //获取访问的方法的名称
        Object[] args = jp.getArgs(); //获取访问的方法的参数

        //获取具体执行的方法的method对象
        if (args == null||args.length==0){
            method = clazz.getMethod(methodName);
        }else   {
            Class[] classArgs = new Class[args.length];
            for (int i=0; i<args.length; i++) {
                classArgs[i] =args[i].getClass();
            }

            clazz.getMethod(methodName,classArgs);

        }

    }

    //后置通知
    @After("execution(* com.itcast.ssm.controller.*.*(..))")
    public void doAfter(JoinPoint jp){
        long time = new Date().getTime() - visitTime.getTime(); //获取访问时长


        String url = "";
        //获取url
        if (clazz != null&&method != null&&clazz !=LogAop.class){
            //1.获取类上的RequestMapping
            RequestMapping classAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if (classAnnotation != null){
                String[] classValue = classAnnotation.value();
                //2.获取方法上的RequestMapping
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if (methodAnnotation != null){
                    String[] methodValue = methodAnnotation.value();
                    //获得到完整url
                    url = classValue[0]+methodValue[0];
                    //获取ip
                    String ip = request.getRemoteAddr();
                    //获取当前操作的用户
                    SecurityContext context = SecurityContextHolder.getContext();//从上下文中获得当前登录的用户
                    User user = (User) context.getAuthentication().getPrincipal();
                    String username = user.getUsername();

                    //将日志相关信息封装到SysLog对象
                    SysLog sysLog = new SysLog();
                    sysLog.setExecutionTime(time);
                    sysLog.setUrl(url);
                    sysLog.setIp(ip);
                    sysLog.setMethod("[类名]" + clazz.getName() +"[方法名]" + method.getName());
                    sysLog.setUsername(username);
                    sysLog.setVisitTime(visitTime);

                    //
                    sysLogService.save(sysLog);
                }
            }

        }


    }
}
