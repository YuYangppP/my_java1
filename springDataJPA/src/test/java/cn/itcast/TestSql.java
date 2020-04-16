package cn.itcast;

import cn.itcast.dao.CustomerDao;
import cn.itcast.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName TestSql.java
 * @Description TODO
 * @Date 2019/12/1 16:23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestSql {

    @Autowired
    private CustomerDao customerDao;

    @Test
    public void testSql(){
        System.out.println(customerDao.findsql());
    }

    @Test
    public void testJpql(){
        System.out.println(customerDao.findJpql());
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void testUpdate(){
        customerDao.update1("人工智能",1l);
    }

    @Test
    public void testFindlike(){
        List<Customer> list = customerDao.findSql1("哈%");
        for (Customer c : list) {
            System.out.println(c);
        }
    }
}
