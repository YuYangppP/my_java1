package cn.itcast;

import cn.itcast.dao.CustomerDao;
import cn.itcast.dao.LinkManDao;
import cn.itcast.domain.Customer;
import cn.itcast.domain.LinkMan;
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
 * @ClassName OneToManyTest.java
 * @Description TODO
 * @Date 2019/12/5 19:40
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class OneToManyTest {
    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private LinkManDao linkManDao;
    @Test
    @Transactional
    @Rollback(false)
    public void testSave(){
        Customer customer = new Customer();
        LinkMan linkMan = new LinkMan();

        customer.setCustName("嘿嘿");
        linkMan.setLkmName("李先生");
        customer.getLinkMans().add(linkMan);
        customerDao.save(customer);

        linkManDao.save(linkMan);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void testSave1(){
        Customer customer = new Customer();
        LinkMan linkMan = new LinkMan();

        customer.setCustName("嘿嘿");
        linkMan.setLkmName("l先生");
        //由于配置了多的一方到一的一方的关联关系（当保存的时候，就已经对外键赋值）
        linkMan.setCustomer(customer);
        customerDao.save(customer);

        linkManDao.save(linkMan);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void testSave2(){
        Customer customer = new Customer();
        LinkMan linkMan = new LinkMan();

        customer.setCustName("111");
        linkMan.setLkmName("l先生");
        customer.getLinkMans().add(linkMan);

        linkMan.setCustomer(customer);

        customerDao.save(customer);

        linkManDao.save(linkMan);
    }

    @Test
    public void testDel(){
        Customer customer = customerDao.findOne(1L);
        customerDao.delete(customer);
    }
}
