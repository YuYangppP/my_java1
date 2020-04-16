package com.yu.service.impl;

import com.yu.domain.User;
import com.yu.mapper.UserMapper;
import com.yu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public User queryUserByUserName(String username) {
		return userMapper.queryUserByUserName(username);
	}


}
