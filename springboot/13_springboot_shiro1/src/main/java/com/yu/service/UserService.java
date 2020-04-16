package com.yu.service;

import com.yu.domain.User;

public interface UserService {

	/**
	 * 根据用户ID查询用户对象
	 */
	public User queryUserByUserName(String username);
}
