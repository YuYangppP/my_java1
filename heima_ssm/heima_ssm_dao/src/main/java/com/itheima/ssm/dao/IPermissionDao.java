package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author:yuyang
 * @data:2019-05-16 20:19
 **/
public interface IPermissionDao {

    //根据角色查询权限
    @Select("select * from permission where id in(select permissionId from role_permission where roleId=#{id})")
    public List<Permission> findPermissionByRoleId(String id)throws Exception;

    //查询所有权限
    @Select("select * from permission")
    public List<Permission> findAll();

    //添加权限
    @Insert("insert into permission (permissionName,url) values (#{permissionName},#{url})")
    public void save(Permission p);
}
