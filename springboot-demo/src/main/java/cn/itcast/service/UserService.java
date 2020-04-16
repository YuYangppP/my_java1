package cn.itcast.service;

import cn.itcast.mapper.UserMapper;
import cn.itcast.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName UserService.java
 * @Description TODO
 * @Date 2019/10/22 17:27
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User queryById(Integer id){
        return userMapper.selectByPrimaryKey(id);
    }

    @Transactional
    public void insertUser(User user){
        userMapper.insert(user);
    }
}
