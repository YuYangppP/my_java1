package com.itcast.ssm.controller;


import com.itcast.ssm.domain.Permission;
import com.itcast.ssm.domain.Role;
import com.itcast.ssm.service.IPermissionService;
import com.itcast.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author:yuyang
 * @data:2019-05-16 21:01
 **/
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;
    @Autowired
    private IPermissionService permissionService;


    //查询要操作的角色和可以添加的权限
    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id",required = true) String roleId){
        ModelAndView mv = new ModelAndView();
        Role role = roleService.findById(roleId);
        List<Permission> permissionList = permissionService.findOtherPermissions(roleId);
        mv.addObject("role",role);
        mv.addObject("permissionList",permissionList);
        mv.setViewName("role-permission-add");
        return mv;
    }

    //为角色添加权限
    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name = "roleId") String roleId,@RequestParam(name = "ids") String[] permissionIds){
        roleService.addPermissionToRole(roleId,permissionIds);
        return "redirect:findAll.do";
    }
    //添加角色
    @RequestMapping("/save.do")
    public String save(Role role)throws Exception{
        roleService.save(role);
        return "redirect:findAll.do";
    }

    //查询所有角色
    @RequestMapping("findAll.do")
    public ModelAndView findAll()throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Role> roleList = roleService.findAll();
        mv.addObject("roleList",roleList);
        mv.setViewName("role-list");
        return mv;
    }
}
