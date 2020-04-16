package com.yu.erp.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yu.erp.sys.common.*;
import com.yu.erp.sys.domain.Permission;
import com.yu.erp.sys.domain.User;
import com.yu.erp.sys.service.PermissionService;
import com.yu.erp.sys.service.RoleService;
import com.yu.erp.sys.vo.PermissionVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName MenuController.java
 * @Description 菜单管理
 * @Date 2020/3/21 15:21
 */

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private RoleService roleService;

    @RequestMapping("loadIndexLeftMenuJson")
    public DataGridView loadIndexLeftMenuJson(PermissionVo permissionVo){
        //查询所有菜单
        QueryWrapper<Permission> queryWrapper = new QueryWrapper<>();
        //设置只能查询菜单
        queryWrapper.eq("type", Constant.TYPE_MENU);
        queryWrapper.eq("available",Constant.TYPE_AVAILABLE_TRUE);

        User user = (User) WebUtils.getSession().getAttribute("user");
        List<Permission> list = null;
        if (user.getType() == Constant.USER_TYPE_SUPER){
            list = permissionService.list(queryWrapper);
        }else {
            //根据用户Id+角色+权限去查询菜单
            Integer userId = user.getId();
            //根据用户Id查询角色
            List<Integer> currentUserRoleIds = roleService.queryUserRoleIdsByUid(userId);
            //根据角色Id查询权限和菜单Id
            Set<Integer> pids = new HashSet<>();
            for (Integer rid : currentUserRoleIds) {
                List<Integer> permissionIds = roleService.queryRolePermissionIdsByRid(rid);
                pids.addAll(permissionIds);

            }
            if (pids.size()>0){
                queryWrapper.in("id",pids);
                list = permissionService.list(queryWrapper);
            }else {
                list = new ArrayList<>();
            }

        }
        List<TreeNode> treeNodes = new ArrayList<>();
        for (Permission permission : list) {
            Integer id = permission.getId();
            Integer pid = permission.getPid();
            String title = permission.getTitle();
            String icon = permission.getIcon();
            String href = permission.getHref();
            Boolean spread = permission.getOpen()==Constant.OPEN_TRUE?true:false;
            treeNodes.add(new TreeNode(id,pid,title,icon,href,spread));
        }
        List<TreeNode> list2 = TreeNodeBuilder.build(treeNodes, 1);

        return new DataGridView(list2);
    }

    /**
     * 菜单管理开始
     */

    /**
     * 加载部门管理左侧的树
     */

    @RequestMapping("loadMenuManagerLeftTreeJson")
    public DataGridView loadDeptManagerLeftTreeJson(PermissionVo permissionVo){
        QueryWrapper<Permission> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type",Constant.TYPE_MENU);
        List<Permission> list = this.permissionService.list(queryWrapper);
        List<TreeNode> treeNodes = new ArrayList<TreeNode>();
        for (Permission menu : list) {
            Boolean spread = menu.getOpen()==1?true:false;
            treeNodes.add(new TreeNode(menu.getId(),menu.getPid(),menu.getTitle(),spread));
        }
        return new DataGridView(treeNodes);
    }



    /**
     * 查询全部部门
     * @param permissionVo
     * @return
     */

    @RequestMapping("loadAllMenu")
    public DataGridView loadAllNotice(PermissionVo permissionVo){
        IPage<Permission> page = new Page<>(permissionVo.getPage(),permissionVo.getLimit());
        QueryWrapper<Permission> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(permissionVo.getId()!=null,"id",permissionVo.getId()).or().eq(permissionVo.getId()!=null,"pid",permissionVo.getId());
        //只查询菜单
        queryWrapper.eq("type",Constant.TYPE_MENU);

        queryWrapper.like(StringUtils.isNotBlank(permissionVo.getTitle()),"title",permissionVo.getTitle());
        queryWrapper.orderByAsc("ordernum");
        this.permissionService.page(page,queryWrapper);
        return new DataGridView(page.getTotal(),page.getRecords());
    }


    /**
     * 添加部门
     */
    @RequestMapping("addMenu")
    public ResultObj addMenu(PermissionVo permissionVo) {
        try {
            //设置添加类型
            permissionVo.setType(Constant.TYPE_MENU);
            this.permissionService.save(permissionVo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /**
     * 修改部门
     */
    @RequestMapping("updateMenu")
    public ResultObj updateMenu(PermissionVo permissionVo) {
        try {
            this.permissionService.updateById(permissionVo);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }

    /**
     * 删除部门
     */
    @RequestMapping("deleteMenu")
    public ResultObj deleteMenu(PermissionVo permissionVo) {
        try {
            this.permissionService.removeById(permissionVo.getId());
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
    /**
     * 检查当前部门是否有子部门
     */
    @RequestMapping("checkMenuHashChildrenNode")
    public Map<String,Object> checkMenuHashChildrenNode(PermissionVo permissionVo){
        Map<String,Object> map = new HashMap<String, Object>();

        QueryWrapper<Permission> queryWrapper = new QueryWrapper<Permission>();
        queryWrapper.eq("pid",permissionVo.getId());
        List<Permission> list = this.permissionService.list(queryWrapper);
        if (list.size()>0){
            map.put("value",true);
        }else {
            map.put("value",false);

        }
        return map;

        }
    /**
     * 加载最大排序码
     */
    @RequestMapping("loadMenuMaxOrderNum")
    public Map<String, Object> loadMenuMaxOrderNum(){
        Map<String,Object> map = new HashMap<String, Object>();
        QueryWrapper<Permission> queryWrapper = new QueryWrapper<Permission>();
        IPage<Permission> page = new Page<Permission>(1,1);
        queryWrapper.orderByDesc("ordernum");
        List<Permission> list = this.permissionService.list(queryWrapper);
        if (list.size()>0){
            map.put("value",list.get(0).getOrdernum()+1);
        }else {
            map.put("value",1);
        }
        return map;
    }
}


