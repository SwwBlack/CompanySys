package com.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.bean.Message;
import com.dao.MessageDao;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.util.DbConnection;

public class MessageDaoImpl implements MessageDao {

	@Override
	//发布新消息方法
	public void addNewMsg(Message message) {
		// TODO Auto-generated method stub
         Connection connection = (Connection) DbConnection.getConnection();//获取链接
         PreparedStatement statement = null;
         String sql = "insert into tb_message(messageTitle,messageContent,employeeId,publishTime) values(?,?,?,?)";
         try {
		     statement = (PreparedStatement) connection.prepareStatement(sql);
		     statement.setString(1, message.getMessageTitle());
		     statement.setString(2, message.getMessageContent());
		     //System.out.println(message.getMessageContent());
		     statement.setInt(3,message.getEmployeeId());
		     statement.setTimestamp(4, new Timestamp(message.getPublishTime().getTime()));
		     statement.executeUpdate();//更新数据
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally {
			DbConnection.close(connection);
			DbConnection.close(statement);
			
		}
	}

	@Override
	//查询message表中所有数据方法
	public List<Message> findAllMessage() {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Message> list = new ArrayList<>();
		String sql = "select * from tb_message";
		connection = (Connection) DbConnection.getConnection();//获取连接
		try {
			statement = (PreparedStatement) connection.prepareStatement(sql);
			resultSet = statement.executeQuery();//获取查询结果集
			while(resultSet.next()){
				Message message = new Message();
				message.setMessageId(resultSet.getInt(1));//设置消息id
				message.setMessageTitle(resultSet.getString(2));//设置标题
				message.setMessageContent(resultSet.getString(3));//设置消息内容
				message.setEmployeeId(resultSet.getInt(4));//设置用户id
				message.setPublishTime(resultSet.getDate(5));//设置发布时间
				list.add(message);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbConnection.close(connection);
			DbConnection.close(statement);
			DbConnection.close(resultSet);
			
		}
		return list;
	}

}
