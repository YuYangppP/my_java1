package com.yu.dao;

import com.yu.utils.DataSourceUtils;
import com.yu.vo.BuMen;
import com.yu.vo.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName TtDao.java
 * @Description TODO
 * @Date 2020/2/27 13:18
 */
public class TtDao {

    public List<BuMen> findTt() throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from bumen";
        List<BuMen> b = runner.query(sql, new BeanListHandler<BuMen>(BuMen.class));

        return b;
    }
}
