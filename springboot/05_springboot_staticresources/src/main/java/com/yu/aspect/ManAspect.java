package com.yu.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName ManAspect.java
 * @Description TODO
 * @Date 2020/4/4 16:50
 */
@Component
@Aspect
public class ManAspect {



    /**
     * 声明切面
     */
    public static final String POINTCUT1 = "execution(* com.yu.domain.Man.eat(..))";


    //前置通知

    //@Before(POINTCUT1)
    public void before(){
        System.out.println("饭前洗手");
    }
    
   //后置通知

    //@After(POINTCUT1)
    public void after(){
        System.out.println("饭后漱口");
    }

  //环绕通知

    @Around(POINTCUT1)
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        before();
        pjp.proceed();
        after();
    }
}
