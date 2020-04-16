package cn.itcast;

import cn.itcast.dao.RoleDao;
import cn.itcast.dao.UserDao;
import cn.itcast.domain.Role;
import cn.itcast.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName ManyToManyTest.java
 * @Description TODO
 * @Date 2019/12/5 22:15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ManyToManyTest {

    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    /**
     * 保存一个用户，保存一个角色
     *
     *  多对多放弃维护权：被动的一方放弃
     */
    @Test
    @Transactional
    @Rollback(false)
    public void  testAdd() {
        User user = new User();
        user.setUserName("小李");

        Role role = new Role();
        role.setRoleName("java程序员");

        //配置用户到角色关系，可以对中间表中的数据进行维护     1-1
        user.getRoles().add(role);

        //配置角色到用户的关系，可以对中间表的数据进行维护     1-1
        role.getUsers().add(user);

        userDao.save(user);
        roleDao.save(role);
    }

}
