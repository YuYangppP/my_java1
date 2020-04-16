package com.yu.controller;

import com.yu.common.ResultObj;
import com.yu.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName UserController.java
 * @Description TODO
 * @Date 2020/4/8 12:00
 */
@RestController
@RequestMapping("user")
@Api(description = "用户管理",value = "UserController")
public class UserController {


    /**
     * 全查询
     */
    @ApiOperation(value ="用户查询" ,consumes = "查询所有用户")
    @GetMapping("queryAllUser")
    public List<User> queryAllUser(){
        List<User> list=new ArrayList<>();
        for (int i = 1; i <=5 ; i++) {
            list.add(new User(1,"小明"+i,"武汉"+i,new Date()));
        }
        return  list;
    }

    /**
     * 根据ID查询一个用户
     */
    @ApiOperation(value ="根据ID查询用户" ,consumes = "根据ID查询用户")
    @GetMapping("queryUserById")
    public User queryAllUser(@RequestParam("userId")Integer id){  //加了RequestParam之后可以解决调试时验证问题
        return  new User(id,"小明","武汉",new Date());
    }

    /**
     * 添加一个用户
     */
    @ApiOperation(value ="添加用户")
    @PostMapping("addUser")
    public ResultObj addUser(@RequestBody User user){//@RequestBody验证前端所有数据非空的同时要求必须提交json格式的数据
        System.out.println(user);
        return  new ResultObj(200,"添加成功");
    }

    /**
     * 添加一个用户
     */
    @ApiOperation(value ="添加用户2")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "userId", value = "用户标识", required = true, paramType = "整数", dataType = "整数"),
            @ApiImplicitParam(name = "userName", value = "用户名称", required = true, paramType = "字符串", dataType = "字符串")
    })
    @PostMapping("addUser2")
    public ResultObj addUser2(User user){//@RequestBody验证前端所有数据非空的同时要求必须提交json格式的数据
        System.out.println(user);
        return  new ResultObj(200,"添加成功");
    }


    /**
     * 添加一个用户
     */
    @ApiOperation(value ="修改用户")
    @PostMapping("updateUser")
    public ResultObj updateUser(@RequestBody User user){//@RequestBody验证前端所有数据非空的同时要求必须提交json格式的数据
        System.out.println(user);
        return  new ResultObj(200,"修改成功");
    }

    /**
     * 根据ID删除一个用户
     */
    @ApiOperation(value ="删除用户")
    @DeleteMapping("deleteUser")
    public ResultObj deleteUser(@RequestParam("userId") Integer id){
        System.out.println(id);
        return  new ResultObj(200,"删除成功");
    }
}