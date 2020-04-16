package cn.itcast;

import cn.itcast.dao.CustomerDao;
import cn.itcast.dao.LinkManDao;
import cn.itcast.domain.Customer;
import cn.itcast.domain.LinkMan;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName TestDaoHang.java
 * @Description TODO
 * @Date 2019/12/5 22:30
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestDaoHang {
    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private LinkManDao linkManDao;

    //测试对象导航查询（查询一个对象的时候，通过此对象查询所有的关联对象）
    @Test
    @Transactional
    public void  testQuery1() {
        //查询id为1的客户
        Customer customer = customerDao.getOne(1L);
        //对象导航查询，此客户下的所有联系人
        Set<LinkMan> linkMans = customer.getLinkMans();

        for (LinkMan linkMan : linkMans) {
            System.out.println(linkMan);
        }
    }

    @Test
    @Transactional // 解决在java代码中的no session问题
    public void  testQuery3() {
        LinkMan linkMan = linkManDao.findOne(2L);
        //对象导航查询所属的客户
        Customer customer = linkMan.getCustomer();
        System.out.println(customer);
    }
}
