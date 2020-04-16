package com.yu.service;

import com.yu.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName UserService.java
 * @Description TODO
 * @Date 2020/4/8 11:04
 */
public interface UserService {

    int deleteByPrimaryKey(Integer id);

    int insert(User user);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(User user);

    List<User> queryAllUser();
}
