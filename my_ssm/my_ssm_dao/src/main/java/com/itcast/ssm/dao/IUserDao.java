package com.itcast.ssm.dao;

import com.itcast.ssm.domain.Role;
import com.itcast.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author:yuyang
 * @data:2019-05-20 19:25
 **/
public interface IUserDao {
    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "com.itcast.ssm.dao.IRoleDao.findRoleByUserId"))
    })
    UserInfo findByUsername(String username);

    //查询所有用户
    @Select("select * from users")
    List<UserInfo> findAll();

    //添加用户
    @Insert("insert into users(username,email,password,phoneNum,status)values(#{username},#{email},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo);

    //用户详情
    @Select("select * from users where id=#{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "com.itcast.ssm.dao.IRoleDao.findRoleByUserId"))
    })
    UserInfo findById(String id);

    @Insert("insert into users_role(userId,roleId) values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId);
}
