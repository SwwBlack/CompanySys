package com.factory;

import com.daoImpl.MessageDaoImpl;

public class MessageDaoImplFactory {
    public static MessageDaoImpl getMessageDaoImpl(){
    	return new MessageDaoImpl();
    }
}
