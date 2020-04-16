package com.itcast.ssm.service;

import com.itcast.ssm.domain.Role;
import com.itcast.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @author:yuyang
 * @data:2019-05-20 19:21
 **/
public interface IUserService extends UserDetailsService{

    List<UserInfo> findAll();

    void save(UserInfo userInfo);

    UserInfo findById(String id);

    void addRoleToUser(String userId, String[] roleIds);
}
