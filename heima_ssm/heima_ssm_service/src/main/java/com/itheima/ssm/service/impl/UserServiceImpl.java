package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.IUserDao;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:yuyang
 * @data:2019-05-15 19:24
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
        UserInfo userInfo = null;
        try {
           userInfo = userDao.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //将自己的user对象封装成UserDetails
        User user = new User(userInfo.getUsername(),userInfo.getPassword(),userInfo.getStatus()==0?false:true,true,true,true,getAuthority(userInfo.getRoles()));
        return user;
    }
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles){
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
    public void save(UserInfo user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDao.save(user);
    }

    //用户详情
    @Override
    public UserInfo findById(String id) {
        return userDao.findById(id);
    }

    //查询用户以及用户可以添加的角色
    @Override
    public List<Role> findOtherRoles(String userId) {
        return userDao.findOtherRoles(userId);
    }

    @Override
    public void addRoleToUser(String userId, String[] roleIds) {
        for (String roleId : roleIds){
            userDao.addRoleToUser(userId,roleId);
        }
    }
}
