package com.yu;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yu.domain.User;
import com.yu.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	void contextLoads() {
		List<User> users = userMapper.queryAllUser();
		for (User user : users) {
			System.out.println(user);
		}
	}

	@Test
	void page() {
		Page<Object> page = PageHelper.startPage(1, 2);
		List<User> users = userMapper.queryAllUser();
		for (User user : users) {
			System.out.println(user);
		}
		System.out.println("总条数"+page.getTotal());
	}

}
