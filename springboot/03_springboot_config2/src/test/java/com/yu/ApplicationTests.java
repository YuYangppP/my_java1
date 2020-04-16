package com.yu;

import com.yu.domain.Student2;
import com.yu.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private Student2 student;

    @Autowired
    private User user;

    @Test
    void contextLoads() {
        System.out.println(student);
    }

    @Test
    void contextLoads1() {
        System.out.println(user);
    }

}
