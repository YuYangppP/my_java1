package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author:yuyang
 * @data:2019-05-16 21:46
 **/
@Controller
@RequestMapping("/permission")
public class PermissionController {


        @Autowired
        private IPermissionService permissionService;

        //添加权限
        @RequestMapping("/save.do")
        public String save(Permission p) throws Exception {
            permissionService.save(p);
            return "redirect:findAll.do";
        }

        //查询所有权限
        @RequestMapping("/findAll.do")
        public ModelAndView findAll() throws Exception {
            List<Permission> permissionList = permissionService.findAll();
            ModelAndView mv = new ModelAndView();
            mv.addObject("permissionList", permissionList);
            mv.setViewName("permission-list");
            return mv;

    }
}
