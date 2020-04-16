package com.yu.service.impl;

import java.util.Date;

import com.yu.domain.User;
import com.yu.service.UserService;

public class UserServiceImpl implements UserService {

	public User queryUserByUserName(String username) {
		User user=null;
		if ("admin".equals(username)) {
			user = new User("admin", "123456", "管理员", "武汉", new Date(), 0);
		} else if ("zhangsan".equals(username)) {
			user = new User("zhangsan", "123456", "张三", "武汉", new Date(), 1);
		} else if ("lishi".equals(username)) {
			user = new User("lishi", "123456", "李四", "武汉", new Date(), 1);
		} else if ("wangwu".equals(username)) {
			user = new User("wangwu", "123456", "王五", "武汉", new Date(), 1);
		} else if ("zhaoliu".equals(username)) {
			user = new User("zhaoliu", "123456", "赵六", "武汉", new Date(), 1);
		}
		return user;
	}

}
