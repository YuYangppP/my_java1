package com.itcast.ssm.service;


import com.itcast.ssm.domain.Role;

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

    //查询其他可以添加的角色
    List<Role> findOtherRoles(String userId);

    //根据id查询角色
    Role findById(String roleId);

    void addPermissionToRole(String roleId, String[] permissionIds);
}
