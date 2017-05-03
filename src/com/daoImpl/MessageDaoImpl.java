package com.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.bean.Message;
import com.dao.MessageDao;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.util.DbConnection;

public class MessageDaoImpl implements MessageDao {

	@Override
	public void addNewMsg(Message message) {
		// TODO Auto-generated method stub
         Connection connection = (Connection) DbConnection.getConnection();
         PreparedStatement statement = null;
         String sql = "insert into tb_message(messageTitle,messageContent,employeeId,publishTime) values(?,?,?,?)";
         try {
		     statement = (PreparedStatement) connection.prepareStatement(sql);
		     statement.setString(1, message.getMessageTitle());
		     statement.setString(2, message.getMessageContent());
		     System.out.println(message.getMessageContent());
		     statement.setInt(3,message.getEmployeeId());
		     statement.setTimestamp(4, new Timestamp(message.getPublishTime().getTime()));
		     statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
