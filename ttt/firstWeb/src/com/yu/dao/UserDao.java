package com.yu.dao;

import com.yu.utils.DataSourceUtils;
import com.yu.vo.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName UserDao.java
 * @Description TODO
 * @Date 2020/2/26 15:16
 */
public class UserDao {
    //添加员工
    public void addUser(User user) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into user values(?,?,?,?)";
        runner.update(sql,user.getUid(),user.getName(),user.getNumber(),user.getBmid());
    }

    //查询
    public List<User> findAllUser() throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from user";
        List<User> userlist = runner.query(sql, new BeanListHandler<User>(User.class));
        return userlist;
    }


    //删除
    public void delUser(int uid) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "delete from user where uid =?";
        runner.update(sql,uid);
    }

    //更新时显示信息
    public User updateUserUI(int uid) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from user where uid = ?";
        User user = runner.query(sql,new BeanHandler<User>(User.class),uid);
        return user;
    }

    //更新
    public void updateUser(User user) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update user set name=?,number=?,bmid=? where uid =?";
        System.out.println("-------"+user.getUid());
        runner.update(sql,user.getName(),user.getNumber(),user.getBmid(),user.getUid());
    }

    //分页获得数据总条数
    public int getCount() throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select count(*) from user";
        Long query = (Long) runner.query(sql, new ScalarHandler());
        return query.intValue();
    }

    //分页显示数据
    public List<User> findProductByPage(int index, int currentCount) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from user limit ?,?";
        List<User> list = runner.query(sql, new BeanListHandler<User>(User.class),index,currentCount);
        return list;
    }

    public void delAllUser(int id) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "delete from user where uid =?";
        runner.update(sql,id);
    }
}
