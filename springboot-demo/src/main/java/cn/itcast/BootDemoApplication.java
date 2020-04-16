package cn.itcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName BootDemoApplication.java
 * @Description TODO
 * @Date 2019/10/22 15:29
 */

@SpringBootApplication
@MapperScan("cn.itcast.mapper")
public class BootDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootDemoApplication.class);
        //
    }
}
