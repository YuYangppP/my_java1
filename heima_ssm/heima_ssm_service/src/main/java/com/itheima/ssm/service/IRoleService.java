package com.itheima.ssm.service;

import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;

import java.util.List;

/**
 * @author:yuyang
 * @data:2019-05-16 21:06
 **/
public interface IRoleService {

    //查询所有角色
    public List<Role> findAll()throws Exception;

    //添加角色
    void save(Role role);


    Role findById(String roleId);


    List<Permission> findOtherPermission(String roleId);

    void addPermissionToRole(String roleId, String[] permissionIds);
}
