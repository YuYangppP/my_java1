package cn.itcast.test;

import cn.itcast.dao.AccountDao;
import cn.itcast.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @author:yuyang
 * @data:2019-05-10 20:33
 **/
public class testMybatis {
    /**
     * 测试查询
     * @throws Exception
     */
    @Test
    public void run1() throws Exception{
        //加载mybatis配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession
        SqlSession session = factory.openSession();
        //获取到代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        //查询所有账户信息
        List<Account> list =  dao.findAll();
        for (Account account : list){
            System.out.println(account);
        }
        session.close();
        in.close();
    }

    /**
     * 测试保存
     * @throws Exception
     */
    @Test
    public void run2() throws Exception{
        Account account = new Account();
        account.setName("熊熊");
        account.setMoney(400d);
        //加载mybatis配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession
        SqlSession session = factory.openSession();
        //获取到代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        //保存
        dao.saveAccount(account);
        //提交事务
        session.commit();
        session.close();
        in.close();
    }
}
