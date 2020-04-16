package com.itcast.ssm.controller;

import com.itcast.ssm.domain.Role;
import com.itcast.ssm.domain.UserInfo;
import com.itcast.ssm.service.IRoleService;
import com.itcast.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author:yuyang
 * @data:2019-05-20 19:52
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;


    //查询要操作的用户以及可以添加的角色
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id",required = true) String userId){
        ModelAndView mv = new ModelAndView();
        UserInfo user = userService.findById(userId);
        List<Role> roleList = roleService.findOtherRoles(userId);
        mv.addObject("user",user);
        mv.addObject("roleList",roleList);
        mv.setViewName("user-role-add");
        return mv;
    }

    //为用户添加角色
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId",required = true) String userId,@RequestParam(name = "ids",required = true) String[] roleIds)throws Exception{
        userService.addRoleToUser(userId,roleIds);
        return "redirect:findAll.do";
    }


    //查询所有
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<UserInfo> userList = userService.findAll();
        mv.addObject("userList",userList);
        mv.setViewName("user-list");
        return mv;
    }

    //添加用户
    @RequestMapping("/save.do")
    public String save(UserInfo userInfo){
        userService.save(userInfo);
        return "redirect:findAll.do";
    }

    //用户详情
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true)String id){
        ModelAndView mv = new ModelAndView();
        UserInfo user = userService.findById(id);
        mv.addObject("user",user);
        mv.setViewName("user-show");
        return mv;
    }
}
