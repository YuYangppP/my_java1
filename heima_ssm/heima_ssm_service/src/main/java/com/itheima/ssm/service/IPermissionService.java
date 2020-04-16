package com.itheima.ssm.service;

import com.itheima.ssm.domain.Permission;

import java.util.List;

/**
 * @author:yuyang
 * @data:2019-05-16 21:48
 **/
public interface IPermissionService {

    /**
     * 查询所有权限
     * @return
     * @throws Exception
     */
    public List<Permission> findAll() throws Exception;

    /**
     * 添加权限
     * @param p
     */
    public void save(Permission p);
}
