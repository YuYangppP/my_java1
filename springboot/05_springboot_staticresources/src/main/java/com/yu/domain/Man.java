package com.yu.domain;

import org.springframework.stereotype.Component;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName Man.java
 * @Description TODO
 * @Date 2020/4/4 16:48
 */
@Component
public class Man {

    public void eat(){
        System.out.println("人吃饭");
    }

    public String sleep(String arg){
        System.out.println("睡觉");
        return "sleep";
    }
}
