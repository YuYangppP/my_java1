package com.yu.config;


import com.yu.domain.Student;

//@Configuration
public class StudentAutoConfig {


//    @Bean
//    @ConfigurationProperties(prefix = "student")

    public Student getStudent() {
        return new Student();
    }
}
