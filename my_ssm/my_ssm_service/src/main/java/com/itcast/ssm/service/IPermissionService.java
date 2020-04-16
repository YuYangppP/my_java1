package com.itcast.ssm.service;

import com.itcast.ssm.domain.Permission;

import java.util.List;

/**
 * @author:yuyang
 * @data:2019-05-16 21:48
 **/
public interface IPermissionService {

    //查询所有权限
    public List<Permission> findAll() throws Exception;

    //添加权限
    public void save(Permission p);

    //查询其他可以添加的权限
    List<Permission> findOtherPermissions(String roleId);

}
