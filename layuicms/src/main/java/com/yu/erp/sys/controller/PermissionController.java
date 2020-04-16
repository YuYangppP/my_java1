package com.yu.erp.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yu.erp.sys.common.Constant;
import com.yu.erp.sys.common.DataGridView;
import com.yu.erp.sys.common.ResultObj;
import com.yu.erp.sys.common.TreeNode;
import com.yu.erp.sys.domain.Permission;
import com.yu.erp.sys.service.PermissionService;
import com.yu.erp.sys.vo.PermissionVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yu
 * @since 2020-03-21
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;



    @RequestMapping("loadPermissionManagerLeftTreeJson")
    public DataGridView loadPermissionManagerLeftTreeJson(PermissionVo permissionVo){
        QueryWrapper<Permission> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type", Constant.TYPE_MENU);
        List<Permission> list = this.permissionService.list(queryWrapper);
        List<TreeNode> treeNodes = new ArrayList<TreeNode>();
        for (Permission permission : list) {
            Boolean spread = permission.getOpen() == 1 ? true : false;
            treeNodes.add(new TreeNode(permission.getId(),permission.getPid(),permission.getTitle(),spread));
        }
        return new DataGridView(treeNodes);
    }



    /**
     * 查询全部权限
     * @param permissionVo
     * @return
     */

    @RequestMapping("loadAllPermission")
    public DataGridView loadAllPermission(PermissionVo permissionVo){
        IPage<Permission> page = new Page<>(permissionVo.getPage(),permissionVo.getLimit());
        QueryWrapper<Permission> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(permissionVo.getId()!=null,"pid",permissionVo.getId());
        //只查询权限
        queryWrapper.eq("type",Constant.TYPE_PERMISSION);

        queryWrapper.like(StringUtils.isNotBlank(permissionVo.getTitle()),"title",permissionVo.getTitle());
        queryWrapper.like(StringUtils.isNotBlank(permissionVo.getPercode()),"percode",permissionVo.getPercode());
        queryWrapper.orderByAsc("ordernum");
        this.permissionService.page(page,queryWrapper);
        return new DataGridView(page.getTotal(),page.getRecords());
    }


    /**
     * 添加部门
     */
    @RequestMapping("addPermission")
    public ResultObj addPermission(PermissionVo permissionVo) {
        try {
            //设置添加类型
            permissionVo.setType(Constant.TYPE_PERMISSION);
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
    @RequestMapping("updatePermission")
    public ResultObj updatePermission(PermissionVo permissionVo) {
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
    @RequestMapping("deletePermission")
    public ResultObj deletePermission(PermissionVo permissionVo) {
        try {
            this.permissionService.removeById(permissionVo.getId());
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 加载最大排序码
     */
    @RequestMapping("loadPermissionMaxOrderNum")
    public Map<String, Object> loadPermissionMaxOrderNum(){
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

