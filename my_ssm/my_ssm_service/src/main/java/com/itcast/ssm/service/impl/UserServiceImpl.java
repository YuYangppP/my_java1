package com.itcast.ssm.service.impl;

import com.itcast.ssm.dao.IUserDao;
import com.itcast.ssm.domain.Role;
import com.itcast.ssm.domain.UserInfo;
import com.itcast.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author:yuyang
 * @data:2019-05-20 19:21
 **/
@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService{

    @Autowired
    private IUserDao userDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

       UserInfo userInfo = userDao.findByUsername(username);
        User user = new User(userInfo.getUsername(),userInfo.getPassword(),userInfo.getStatus()==0?false:true,true,true,true,getAuthority(userInfo.getRoles()));
        return user;
    }

    private List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles){
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return list;

    }

    //查询所有用户
    @Override
    public List<UserInfo> findAll() {
        return userDao.findAll();
    }

    //添加用户
    @Override
    public void save(UserInfo userInfo) {
        userDao.save(userInfo);
    }

    //用户详情
    @Override
    public UserInfo findById(String id) {
        return userDao.findById(id);
    }

    @Override
    public void addRoleToUser(String userId, String[] roleIds) {
        for (String roleId : roleIds){
            userDao.addRoleToUser(userId,roleId);
        }
    }

}
