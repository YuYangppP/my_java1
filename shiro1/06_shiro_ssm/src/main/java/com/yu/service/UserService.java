package com.yu.service;

import com.yu.domain.User;

public interface UserService {

	/**
	 * 根据用户名查询用户对象
	 * @param username
	 * @return
	 */
	User queryUserByUserName(String username);

}
