package cn.itcast.service;

import cn.itcast.domain.Account;

import java.util.List;

/**
 * @author:yuyang
 * @data:2019-05-10 19:06
 **/
public interface AccountService {
    //查询所有账户
    public List<Account> findAll();
    //保存账户信息
    public void saveAccount(Account account);
}
