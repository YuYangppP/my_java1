package com.yu.domain;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Data
@AllArgsConstructor
@NoArgsConstructor
//@ConfigurationProperties(prefix="student")
public class Person {

	@Value("${student.id}")
	private Integer id;
	private String name;
	private Integer age;
	private String [] hobby;
	private List<String> lists;
	private Map<String,String> maps;
	private Set<String> sets;
	private Date birth;
}
