package cn.itcast.web;

import cn.itcast.pojo.User;
import cn.itcast.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName HelloController.java
 * @Description TODO
 * @Date 2019/10/22 15:33
 */
@RestController
@Slf4j
public class HelloController {

    @Autowired
    private UserService userService;

   @GetMapping("/user/{id}")
    public User hello(@PathVariable("id") Integer id){
        return userService.queryById(id);
    }

    @GetMapping("hello")
    public String hello(){
        //System.out.println("hello method is running");
        log.debug("hello method is running");
        return "hello springBoot!";
    }


}
