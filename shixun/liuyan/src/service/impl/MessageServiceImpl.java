package service.impl;

import dao.MessDao;
import dao.impl.MessDaoImpl;
import domain.Message;
import service.MessService;
import utils.DataSourceUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName MessageServiceImpl.java
 * @Description TODO
 * @Date 2019/12/3 14:09
 */
public class MessageServiceImpl implements MessService {
    private MessDao dao = new MessDaoImpl();

    @Override
    public void addMessage(Message m) {
        try {
            DataSourceUtils.startTransaction();
            dao.addMessage(m);
        } catch (SQLException e) {
            try {
                DataSourceUtils.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                DataSourceUtils.commitAndRelease();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Message> findAllMessage() {
        List<Message> message = null;
        try {
            message = dao.findAllMessage();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return message;
    }

    @Override
    public void delMessage(int idd) {
        try {
            dao.delMessage(idd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Message findMessageById(int ids) {
        Message mes = null;
        try {
            mes = dao.findMessageById(ids);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mes;
    }

    @Override
    public void updateMessage(Message m) {
        try {
            dao.updateMessage(m);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
