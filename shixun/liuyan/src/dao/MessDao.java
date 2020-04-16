package dao;

import domain.Message;

import java.sql.SQLException;
import java.util.List;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName MessDao.java
 * @Description TODO
 * @Date 2019/12/3 14:17
 */
public interface MessDao {
    void addMessage(Message m) throws SQLException;

    List<Message> findAllMessage() throws SQLException;

    void delMessage(int idd) throws SQLException;

    Message findMessageById(int ids) throws SQLException;

    void updateMessage(Message m) throws SQLException;
}
