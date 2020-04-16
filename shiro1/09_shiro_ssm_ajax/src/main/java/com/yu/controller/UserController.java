package com.yu.controller;

import com.yu.domain.User;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName UserController.java
 * @Description TODO
 * @Date 2020/4/11 22:23
 */
@RestController
@RequestMapping("user")
public class UserController {

    @RequiresPermissions("user:query")
    @RequestMapping("queryUser")
    public Map<String,Object> queryUser(){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("code",0);
        map.put("msg","查询成功");
        return map;
    }

    @RequiresPermissions("user:add")
    @RequestMapping("addUser")
    public Map<String,Object> addUser(){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("code",0);
        map.put("msg","添加成功");
        return map;
    }

    @RequiresPermissions("user:update")
    @RequestMapping("updateUser")
    public Map<String,Object> updateUser(){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("code",0);
        map.put("msg","更新成功");
        return map;
    }

    @RequiresPermissions("user:delete")
    @RequestMapping("deleteUser")
    public Map<String,Object> deleteUser(){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("code",0);
        map.put("msg","删除成功");
        return map;
    }

    @RequiresPermissions("user:export")
    @RequestMapping("exportUser")
    public Map<String,Object> exportUser(){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("code",0);
        map.put("msg","导出成功");
        return map;
    }
}
