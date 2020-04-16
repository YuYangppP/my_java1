package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author:yuyang
 * @data:2019-05-16 19:09
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;



    //给用户添加角色
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId",required = true) String userId,@RequestParam(name = "ids",required = true) String[] roleIds)throws Exception{
        userService.addRoleToUser(userId,roleIds);
        return "redirect:findAll.do";
    }

    //查询用户以及用户可以添加的角色
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id",required = true) String userId)throws Exception{
        ModelAndView mv = new ModelAndView();
        UserInfo user = userService.findById(userId);
        List<Role> roleList = userService.findOtherRoles(userId);
        mv.addObject("user",user);
        mv.addObject("roleList",roleList);
        mv.setViewName("user-role-add");
        return mv;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true) String id) throws Exception{
        ModelAndView mv = new ModelAndView();
        UserInfo user = userService.findById(id);
        mv.addObject("user",user);
        mv.setViewName("user-show");
        return mv;
    }

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<UserInfo> users = userService.findAll();
        mv.addObject("userList",users);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(UserInfo user) throws Exception{
        userService.save(user);
        return "redirect:findAll.do";
    }
}
