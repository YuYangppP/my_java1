package dao.impl;

import dao.MessDao;
import domain.Message;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DataSourceUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName MessDaoImpl.java
 * @Description TODO
 * @Date 2019/12/3 14:14
 */
public class MessDaoImpl implements MessDao {


    @Override
    public void addMessage(Message m) throws SQLException{
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into Message values(?,?,?,?,?)";
        runner.update(sql,m.getId(),m.getNickname(),m.getMessage(),m.getMtime(),m.getIp());

    }

    @Override
    public List<Message> findAllMessage() throws SQLException{
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from message order by mtime desc";
        List<Message> list = runner.query(sql, new BeanListHandler<Message>(Message.class));
        return list;
    }

    @Override
    public void delMessage(int idd) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "delete from message where id =?";
        runner.update(sql,idd);
    }

    @Override
    public Message findMessageById(int ids) throws SQLException{
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from message where id = ?";
        Message mes = runner.query(sql,new BeanHandler<Message>(Message.class),ids);
        return mes;
    }

    @Override
    public void updateMessage(Message m) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update message set nickname=?,message=?,mtime=?,ip=? where id =?";
        runner.update(sql,m.getNickname(),m.getMessage(),m.getMtime(),m.getIp(),m.getId());
    }
}
