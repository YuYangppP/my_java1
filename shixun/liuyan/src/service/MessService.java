package service;

import domain.Message;

import java.util.List;

public interface MessService {
    //添加信息
    void addMessage(Message m);
    //查询信息
    List<Message> findAllMessage();
    //单个删除信息
    void delMessage(int idd);
    //根据id查询信息（编辑信息时回显）
    Message findMessageById(int ids);
    //更新信息
    void updateMessage(Message m);
}
