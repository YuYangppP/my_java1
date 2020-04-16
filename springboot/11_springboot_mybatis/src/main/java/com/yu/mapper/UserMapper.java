package com.yu.mapper;

import com.yu.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName UserMapper.java
 * @Description TODO
 * @Date 2020/4/6 15:59
 */
//@Mapper
public interface UserMapper  {


    //@Delete("delete from sys_user where id=#{id}")
    int deleteByPrimaryKey(@Param("id")Integer id);

    //@Insert("insert into sys_user(name,address,birth) values(#{name},#{address},#{birth})")
    int insert(User user);

    //@Select("select * from sys_user where id=#{value}")
    User selectByPrimaryKey(@Param("id")Integer id);

    //@Update("update sys_user set name=#{name},address=#{address},birth=#{birth} where id=#{id}")
    int updateByPrimaryKey(User user);

    //@Select("select * from sys_user")
    List<User> queryAllUser();
}
