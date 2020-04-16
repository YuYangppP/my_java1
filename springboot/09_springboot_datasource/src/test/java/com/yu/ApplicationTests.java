package com.yu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@SpringBootTest
class ApplicationTests {

	@Autowired
	private DataSource dataSource;

	@Test
	void contextLoads() {
		System.out.println(dataSource);
	}

}
