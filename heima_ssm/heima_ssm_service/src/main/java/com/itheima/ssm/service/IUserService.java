package com.itheima.ssm.service;

import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @author:yuyang
 * @data:2019-05-15 19:23
 **/
public interface IUserService extends UserDetailsService {

    //查询所有用户
    List<UserInfo> findAll();

    //添加用户
    void save(UserInfo user);

    //用户详情
    UserInfo findById(String id);

    //查询用户以及用户可以添加的角色
    List<Role> findOtherRoles(String userId);

    //给用户添加角色
    void addRoleToUser(String userId, String[] roleIds);
}
