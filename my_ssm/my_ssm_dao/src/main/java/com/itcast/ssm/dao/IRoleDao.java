package com.itcast.ssm.dao;

import com.itcast.ssm.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author:yuyang
 * @data:2019-05-20 19:36
 **/
public interface IRoleDao {
    @Select("select * from role where id in(select roleId from users_role where userId=#{userId})")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "com.itcast.ssm.dao.IPermissionDao.findPermissionByRoleId"))

    })
    List<Role> findRoleByUserId(String userId)throws Exception;

    //查询所有角色
    @Select("select * from role")
    public List<Role> findAll();

    @Insert("insert into role (roleName,roleDesc) values(#{roleName},#{roleDesc})")
    public void save(Role role);

    @Select("select * from role where id not in (select roleId from users_role where userId=#{userId})")
    List<Role> findOtherRoles(String userId);

    @Select("select * from role where id = #{roleId}")
    Role findById(String roleId);

    @Insert("insert into role_permission (roleId,permissionId) values(#{roleId},#{permissionId})")
    void addPermissionToRole(@Param("roleId") String roleId, @Param("permissionId") String permissionId);
}
