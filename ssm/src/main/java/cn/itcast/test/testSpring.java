package cn.itcast.test;

import cn.itcast.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author:yuyang
 * @data:2019-05-10 19:31
 **/
public class testSpring {
    @Test
    public void run(){
        //加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        //获取对象
        AccountService as = (AccountService) ac.getBean("accountService");

        //调用方法
        as.findAll();
    }
}
