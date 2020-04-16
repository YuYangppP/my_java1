package com.yu;

import com.yu.domain.Persion;
import com.yu.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private User user;

    @Autowired
    private Persion persion;

    @Test
    void contextLoads() {
        System.out.println(user);
        System.out.println(persion);
    }

}
