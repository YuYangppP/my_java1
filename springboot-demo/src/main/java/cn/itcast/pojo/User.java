package cn.itcast.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName User.java
 * @Description TODO
 * @Date 2019/10/22 16:22
 */
@Data
@Table(name = "user")
public class User {
    /** id*/
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String email;
    private String telephone;
    private Date birthday;
    private String sex;

}
