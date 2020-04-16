package com.yu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@SpringBootTest
class ApplicationTests {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	void contextLoads() {
		Map<String, Object> map = jdbcTemplate.queryForMap("select * from bumen where bid=1");
		System.out.println(map);
	}

	@Test
	void contextLoads2() {
		List<Map<String, Object>> map = jdbcTemplate.queryForList("select * from bumen");
		System.out.println(map);
	}

}
