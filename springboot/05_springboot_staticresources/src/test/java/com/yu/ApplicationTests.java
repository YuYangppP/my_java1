package com.yu;

import com.yu.domain.Man;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private Man man;

    @Test
    void contextLoads() {
        man.sleep("11");
    }

}
