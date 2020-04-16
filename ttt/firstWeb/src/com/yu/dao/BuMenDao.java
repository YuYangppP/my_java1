package com.yu.dao;

import com.yu.utils.DataSourceUtils;
import com.yu.vo.BuMen;
import com.yu.vo.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName BuMenDao.java
 * @Description TODO
 * @Date 2020/2/26 17:17
 */
public class BuMenDao {
    public List<BuMen> findAllBuMen() throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from bumen";
        List<BuMen> buMenList = runner.query(sql, new BeanListHandler<BuMen>(BuMen.class));
        System.out.println(buMenList);
        return buMenList;
    }

    public void delBuMen(int bid) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "delete from bumen where bid =?";
        runner.update(sql,bid);
    }

    public void addBuMen(BuMen buMen) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into bumen values(?,?,?,?,?)";
        runner.update(sql, buMen.getBid(),buMen.getBname(),buMen.getCreateTime(),buMen.getTelephone(),buMen.getLeader());
    }

    public BuMen findBuMenById(int bid) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from bumen where bid = ?";
        BuMen buMen = runner.query(sql,new BeanHandler<BuMen>(BuMen.class),bid);
        return buMen;
    }

    public void updateBuMen(BuMen buMen) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update bumen set bname=?,telephone=?,leader=? where bid =?";
        runner.update(sql,buMen.getBname(),buMen.getTelephone(),buMen.getLeader(),buMen.getBid());
    }

    public List<BuMen> findAllBuMen1() throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select bid,bname from bumen";
        List<BuMen> buMenList = runner.query(sql, new BeanListHandler<BuMen>(BuMen.class));
        System.out.println(buMenList);
        return buMenList;
    }
}
