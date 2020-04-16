package com.yu.erp.sys.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yu.erp.sys.common.DataGridView;
import com.yu.erp.sys.common.ResultObj;
import com.yu.erp.sys.common.TreeNode;
import com.yu.erp.sys.common.WebUtils;
import com.yu.erp.sys.domain.Dept;
import com.yu.erp.sys.domain.User;
import com.yu.erp.sys.service.DeptService;
import com.yu.erp.sys.vo.DeptVo;
import com.yu.erp.sys.vo.NoticeVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yu
 * @since 2020-03-25
 */
@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    /**
     * 加载部门管理左侧的树
     */

    @RequestMapping("loadDeptManagerLeftTreeJson")
    public DataGridView loadDeptManagerLeftTreeJson(DeptVo deptVo){
        List<Dept> list = this.deptService.list();
        List<TreeNode> treeNodes = new ArrayList<TreeNode>();
        for (Dept dept : list) {
            Boolean spread = dept.getOpen()==1?true:false;
            treeNodes.add(new TreeNode(dept.getId(),dept.getPid(),dept.getName(),spread));
        }
        return new DataGridView(treeNodes);
    }

    /**
     * 查询全部部门
     * @param deptVo
     * @return
     */
    @RequestMapping("loadAllDept")
    public DataGridView loadAllDept(DeptVo deptVo){
        IPage<Dept> page = new Page<>(deptVo.getPage(),deptVo.getLimit());
        QueryWrapper<Dept> queryWrapper = new QueryWrapper<>();

        queryWrapper.like(StringUtils.isNotBlank(deptVo.getName()),"title",deptVo.getName());
        queryWrapper.like(StringUtils.isNotBlank(deptVo.getAddress()),"address",deptVo.getAddress());
        queryWrapper.like(StringUtils.isNotBlank(deptVo.getRemark()),"remark",deptVo.getRemark());
        queryWrapper.eq(deptVo.getId()!=null,"id",deptVo.getId()).or().eq(deptVo.getId()!=null,"pid",deptVo.getId());
        queryWrapper.orderByAsc("ordernum");
        this.deptService.page(page,queryWrapper);
        return new DataGridView(page.getTotal(),page.getRecords());
    }


    /**
     * 添加部门
     */
    @RequestMapping("addDept")
    public ResultObj addDept(DeptVo deptVo) {
        try {
            deptVo.setCreatetime(new Date());
            this.deptService.save(deptVo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /**
     * 修改部门
     */
    @RequestMapping("updateDept")
    public ResultObj updateDept(DeptVo deptVo) {
        try {
            deptVo.setCreatetime(new Date());
            this.deptService.updateById(deptVo);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }

    /**
     * 删除部门
     */
    @RequestMapping("deleteDept")
    public ResultObj deleteDept(DeptVo deptVo) {
        try {
            deptVo.setCreatetime(new Date());
            this.deptService.removeById(deptVo.getId());
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
    /**
     * 检查当前部门是否有子部门
     */
    @RequestMapping("checkDeptHashChildrenNode")
    public Map<String,Object> checkDeptHashChildrenNode(DeptVo deptVo){
        Map<String,Object> map = new HashMap<String, Object>();

        QueryWrapper<Dept> queryWrapper = new QueryWrapper<Dept>();
        queryWrapper.eq("pid",deptVo.getId());
        List<Dept> list = this.deptService.list(queryWrapper);
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
    @RequestMapping("loadDeptMaxOrderNum")
    public Map<String, Object> loadDeptMaxOrderNum(){
        Map<String,Object> map = new HashMap<String, Object>();
        QueryWrapper<Dept> queryWrapper = new QueryWrapper<Dept>();
        queryWrapper.orderByDesc("ordernum");
        List<Dept> list = this.deptService.list(queryWrapper);
        if (list.size()>0){
            map.put("value",list.get(0).getOrdernum()+1);
        }else {
            map.put("value",1);
        }
        return map;
    }

}

