package com.yu.service.impl;

import com.yu.domain.User;
import com.yu.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.yu.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;


    public User queryUserByUserName(@Param("username") String username) {
        User user = userMapper.queryUserByUserName(username);
        return user;
    }
}
