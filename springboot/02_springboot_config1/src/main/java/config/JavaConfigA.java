package config;

import com.yu.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName JavaConfigA.java
 * @Description TODO
 * @Date 2020/3/30 12:43
 */
//相当于创建一个spring的xml文件

@Configuration
public class JavaConfigA {

    //相当于xml里面<bean id="user" name="user" address="com.yu.domain.User">

    @Bean
    public User getUser1(){
        return new User(1,"小明","武汉");
    }
}
