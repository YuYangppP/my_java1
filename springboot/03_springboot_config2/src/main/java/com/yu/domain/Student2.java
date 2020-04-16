package com.yu.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@ConfigurationProperties(prefix = "student")
@PropertySource(value = {"classpath:student.properties"})
@Validated
public class Student2 {

    @Email
    private String email;
    private Integer id;
    private String name;
    private String[] hobby;
    private List<String> lists;
    private Map<String, String> maps;
    private Set<String> sets;
    private Integer age;
    private Date birth;
    private String userName;

}
