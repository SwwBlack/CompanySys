package com.dao;

import java.util.List;

import com.bean.Message;
public interface MessageDao {
    public void addNewMsg(Message message);
    public List<Message> findAllMessage();
}
