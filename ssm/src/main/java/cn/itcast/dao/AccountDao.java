package cn.itcast.dao;

import cn.itcast.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author:yuyang
 * @data:2019-05-10 19:03
 **/
@Repository
public interface AccountDao {
    //查询所有账户
    @Select("select * from account")
    public List<Account> findAll();
    //保存账户信息
    @Insert("insert into account (name,money) values(#{name},#{money})")
    public void saveAccount(Account account);
}
