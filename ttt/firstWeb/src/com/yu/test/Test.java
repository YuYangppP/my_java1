package com.yu.test;

import com.yu.vo.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import com.yu.utils.DataSourceUtils;

import java.sql.SQLException;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName Test.java
 * @Description TODO
 * @Date 2020/2/25 13:43
 */
public class Test {
    public static User findProductByPid(int user_id) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from sys_user where user_id=?";
        User user = runner.query(sql, new BeanHandler<User>(User.class), user_id);
        return user;
    }
    public static void main(String[] args) throws SQLException {
        User byPid = findProductByPid(1);
        System.out.println(byPid);
    }
}
