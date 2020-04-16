package com.yu.dao;

import com.yu.utils.DataSourceUtils;
import com.yu.vo.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName TuDao.java
 * @Description TODO
 * @Date 2020/2/27 10:52
 */
public class TuDao {
    public List<Map<String, Object>> findTu() throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "SELECT bname,IFNULL(total,0) c FROM bumen t1 LEFT OUTER JOIN (SELECT bmid,COUNT(bmid) AS total FROM user GROUP BY bmid) t2 on bid=bmid;";
        List<Map<String, Object>> mapList = runner.query(sql, new MapListHandler());
        return mapList;
    }
   /* */
}
