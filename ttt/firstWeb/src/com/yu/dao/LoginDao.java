package com.yu.dao;

import java.sql.SQLException;

import com.yu.vo.Manager;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.yu.utils.DataSourceUtils;

public class LoginDao {
	 public Manager login(String name, String pwd) throws SQLException {
	        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
	        String sql = "select * from manager where name=? and pwd=?";
	        return runner.query(sql, new BeanHandler<Manager>(Manager.class), name,pwd);
	    }
}
