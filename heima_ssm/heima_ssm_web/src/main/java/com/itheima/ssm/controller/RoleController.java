package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.service.IRoleService;
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

    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name = "roleId") String roleId,@RequestParam(name = "ids") String[] permissionIds) throws Exception {
        roleService.addPermissionToRole(roleId, permissionIds);
        return "redirect:findAll.do";
    }


    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id", required = true) String roleId) throws Exception {
        ModelAndView mv = new ModelAndView();
        Role role = roleService.findById(roleId);
        mv.addObject("role", role);
        List<Permission> permissionList = roleService.findOtherPermission(roleId);
        mv.addObject("permissionList", permissionList);
        mv.setViewName("role-permission-add");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Role role)throws Exception{
        roleService.save(role);
        return "redirect:findAll.do";
    }



    /**
     * 查询所有角色
     * @return
     * @throws Exception
     */
    @RequestMapping("findAll.do")
    public ModelAndView findAll()throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Role> roleList = roleService.findAll();
        mv.addObject("roleList",roleList);
        mv.setViewName("role-list");
        return mv;
    }
}
