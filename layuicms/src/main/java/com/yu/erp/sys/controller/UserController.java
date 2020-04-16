package com.yu.erp.sys.controller;


import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yu.erp.sys.common.Constant;
import com.yu.erp.sys.common.DataGridView;
import com.yu.erp.sys.common.PinyinUtils;
import com.yu.erp.sys.common.ResultObj;
import com.yu.erp.sys.domain.Dept;
import com.yu.erp.sys.domain.Role;
import com.yu.erp.sys.domain.User;
import com.yu.erp.sys.service.DeptService;
import com.yu.erp.sys.service.RoleService;
import com.yu.erp.sys.service.UserService;
import com.yu.erp.sys.vo.UserVo;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 老雷
 * @since 2020-03-21
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private DeptService deptService;

    @Autowired
    private RoleService roleService;

    /**
     * 用户全查询
     */
    @RequestMapping("loadAllUser")
    public DataGridView loadAllUser(UserVo userVo){
        IPage<User> page = new Page<User>(userVo.getPage(),userVo.getLimit());
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        //根据用户登录名称以及用户名称模糊查询用户
        queryWrapper.like(StringUtils.isNotBlank(userVo.getName()),"loginname",userVo.getName()).or().like(StringUtils.isNotBlank(userVo.getName()),"name",userVo.getName());
        queryWrapper.like(StringUtils.isNotBlank(userVo.getAddress()),"address",userVo.getAddress());
        //查询系统用户
        queryWrapper.eq("type", Constant.USER_TYPE_NORMAL);
        queryWrapper.eq(userVo.getDeptid()!=null,"deptid",userVo.getDeptid());
        queryWrapper.orderByDesc("id");
        userService.page(page,queryWrapper);

        //将所有用户数据放入list中
        List<User> list = page.getRecords();
        for (User user : list) {
            Integer deptId = user.getDeptid();
            if (deptId!=null){
                //先从缓存中去取，如果缓存中没有就去数据库中取
                Dept one = deptService.getById(deptId);
                //设置user的部门名称
                user.setDeptname(one.getName());
            }
            Integer mgr = user.getMgr();
            if (mgr!=null&&mgr!=0){
                User one = userService.getById(mgr);
                //设置user的领导名称
                user.setLeadername(one.getName());
            }
        }
        return new DataGridView(page.getTotal(),list);
    }

    /**
     * 加载最大排序码
     */
    @RequestMapping("loadUserMaxOrderNum")
    public Map<String, Object> loadUserMaxOrderNum(){
        Map<String,Object> map = new HashMap<String, Object>();
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.orderByDesc("ordernum");
        List<User> list = this.userService.list(queryWrapper);
        if (list.size()>0){
            map.put("value",list.get(0).getOrdernum()+1);
        }else {
            map.put("value",1);
        }
        return map;
    }

    /**
     * 根据部门Id查询用户
     */
    @RequestMapping("loadUsersByDeptId")
    public DataGridView loadUsersByDeptId(Integer deptid){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(deptid!=null,"deptid",deptid);
        queryWrapper.eq("available",Constant.TYPE_AVAILABLE_TRUE);
        queryWrapper.eq("type",Constant.USER_TYPE_NORMAL);
        List<User> list = this.userService.list(queryWrapper);
        return new DataGridView(list);
    }

    /**
     * 把用户名转成拼音
     */
    @RequestMapping("changeChineseToPinyin")
    public Map<String,Object> changeChineseToPinyin(String username){
        Map<String,Object> map=new HashMap<>();
        if(null!=username) {
            map.put("value", PinyinUtils.getPinYin(username));
        }else {
            map.put("value", "");
        }
        return map;
    }

    /**
     * 添加用户
     */
    @RequestMapping("addUser")
    public ResultObj addUser(UserVo userVo){
        try {
            //设置类型
            userVo.setType(Constant.USER_TYPE_NORMAL);
            userVo.setHiredate(new Date());
            String salt = IdUtil.simpleUUID().toUpperCase();
            userVo.setSalt(salt);
            userVo.setPwd(new Md5Hash(Constant.USER_DEFAULT_PWD,salt,2).toString());
            this.userService.save(userVo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /**
     * 修改用户
     */
    @RequestMapping("updateUser")
    public ResultObj updateUser(UserVo userVo){
        try {
            this.userService.updateById(userVo);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }

    /**
     * 删除用户
     */
    @RequestMapping("deleteUser")
    public ResultObj deleteUser(Integer id){
        try {
            this.userService.removeById(id);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }



    /**
     * 根据用户Id查询一个用户
     */
    @RequestMapping("loadUserById")
    public DataGridView loadUserById(Integer id){
        return new DataGridView(this.userService.getById(id));
    }

    /**
     * 重置用户密码
     */
    @RequestMapping("resetPwd")
    public ResultObj resetPwd(Integer id){
        try {
            User user = new User();
            user.setId(id);
            String salt = IdUtil.simpleUUID().toUpperCase();
            user.setSalt(salt);
            user.setPwd(new Md5Hash(Constant.USER_DEFAULT_PWD,salt,2).toString());
            this.userService.updateById(user);
            return ResultObj.RESET_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.RESET_ERROR;
        }
    }

    /**
     * 根据用户Id加载查询角色并选中已分配的角色
     */
    @RequestMapping("initRoleByUserId")
    public DataGridView initRoleByUserId(Integer id){
        //查询所有可用的角色
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("available",Constant.TYPE_AVAILABLE_TRUE);
        List<Map<String, Object>> listMaps = this.roleService.listMaps(queryWrapper);


        //查询当前用户拥有的角色的Id
        List<Integer> currentUserRoleId = this.roleService.queryUserRoleIdsByUid(id);
        for (Map<String, Object> map : listMaps) {
            Boolean LAY_CHECKED=false;
            Integer roleId = (Integer) map.get("id");
            for (Integer rid : currentUserRoleId) {
                if (rid==roleId){
                    LAY_CHECKED=true;
                    break;
                }
            }
            map.put("LAY_CHECKED",LAY_CHECKED);
        }
        return new DataGridView(Long.valueOf(listMaps.size()),listMaps);
    }

    /**
     * 给用户添加角色
     */
    @RequestMapping("saveUserRole")
    public ResultObj saveUserRole(Integer uid,Integer[] ids){
        try {
            this.userService.saveUserRole(uid,ids);
            return ResultObj.DISPATCH_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DISPATCH_ERROR;
        }
    }

}

