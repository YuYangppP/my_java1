package cn.itcast;

import cn.itcast.dao.CustomerDao;
import cn.itcast.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName CustomerDaoTest.java
 * @Description TODO
 * @Date 2019/12/1 15:00
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class CustomerDaoTest {

    @Autowired
    private CustomerDao customerDao;


    //根据id查询
    @Test
    public void testFindOne(){
        Customer one = customerDao.findOne(1l);
        System.out.println(one);
    }

    /**
     * 添加
     */
    @Test
    public void testSave(){
        Customer c = new Customer();
        c.setCustName("软件");
        c.setCustLevel("vip");
        c.setCustAddress("吉林");
        customerDao.save(c);
    }

    /**
     * 修改
     */
    @Test
    public void testUpdate(){
        Customer cc = new Customer();
        cc.setCustId(2l);
        cc.setCustName("计算机");
        customerDao.save(cc);
    }

    /**
     * 删除
     */
    @Test
    public void testDelete(){
        customerDao.delete(2l);
    }

    /**
     * 查询所有
     */
    @Test
    public void testfindAll(){
        List<Customer> customer = customerDao.findAll();
        for (Customer l : customer){
            System.out.println(l);
        }
    }

    /**
     * 测试统计查询：查询用户的数量
     */
    @Test
    public void testCount(){
        Long number = customerDao.count();
        System.out.println(number);
    }
    /**
     * 根据条件查询用户是否存在
     */
    @Test
    public void  testExists() {
        boolean exists = customerDao.exists(3l);
        System.out.println("是否存在："+exists);
    }
    /**
     * getOne:  em.getReference :延迟加载
     * findOne: em.find         :立即加载
     */
    @Test
    @Transactional
    public void testGetOne(){
        Customer b = customerDao.getOne(3l);
        System.out.println(b);
    }
}
