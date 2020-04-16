package com.yu.service.impl;

import java.util.Date;

import com.yu.domain.User;
import com.yu.service.UserService;

public class UserServiceImpl implements UserService {

	public User queryUserByUserName(String username) {
		User user=null;
		if ("admin".equals(username)) {
			user = new User("admin", "928bfd2577490322a6e19b793691467e", "管理员", "武汉", new Date(), 0);
		} else if ("zhangsan".equals(username)) {
			user = new User("zhangsan", "654407ac2e454fe560337510aa6adb97", "张三", "武汉", new Date(), 1);
		} else if ("lishi".equals(username)) {
			user = new User("lishi", "c026eb3b2506668390c4a1c1b4417eb0", "李四", "武汉", new Date(), 1);
		} else if ("wangwu".equals(username)) {
			user = new User("wangwu", "4d6a8546c786edaed7ec4858bee8975c", "王五", "武汉", new Date(), 1);
		} else if ("zhaoliu".equals(username)) {
			user = new User("zhaoliu", "a33005a4ff1f4890efaee6f754259839", "赵六", "武汉", new Date(), 1);
		}
		return user;
	}

}
