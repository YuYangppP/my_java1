package com.yu.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Component
//@ConfigurationProperties(prefix = "student")
public class Student {

    @Value("${student.id}")
    private Integer id;
    @Value("${student.name}")
    private String name;
    //    @Value("${student.hobby}")
    private String[] hobby;
    //    @Value("${student.lists}")
    private List<String> lists;
    //    @Value("${student.maps}")
    private Map<String, String> maps;
    //    @Value("${student.sets}")
    private Set<String> sets;
    //    @Value("${random.int(1,100)}")
    @Value("#{1+1}")
    private Integer age;

    @Value("${student.birth}")
    private Date birth;
    @Value("${student.user-name}")
    private String userName;

}
