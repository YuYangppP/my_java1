package com.yu.service.impl;

import com.yu.domain.User;
import com.yu.mapper.UserMapper;
import com.yu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName UserServiceImpl.java
 * @Description TODO
 * @Date 2020/4/8 11:13
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(User user) {
        return 0;
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKey(User user) {
        return 0;
    }

    @Override
    public List<User> queryAllUser() {
        return null;
    }
}
