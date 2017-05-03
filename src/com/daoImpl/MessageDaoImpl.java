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
	//��������Ϣ����
	public void addNewMsg(Message message) {
		// TODO Auto-generated method stub
         Connection connection = (Connection) DbConnection.getConnection();//��ȡ����
         PreparedStatement statement = null;
         String sql = "insert into tb_message(messageTitle,messageContent,employeeId,publishTime) values(?,?,?,?)";
         try {
		     statement = (PreparedStatement) connection.prepareStatement(sql);
		     statement.setString(1, message.getMessageTitle());
		     statement.setString(2, message.getMessageContent());
		     //System.out.println(message.getMessageContent());
		     statement.setInt(3,message.getEmployeeId());
		     statement.setTimestamp(4, new Timestamp(message.getPublishTime().getTime()));
		     statement.executeUpdate();//��������
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally {
			DbConnection.close(connection);
			DbConnection.close(statement);
			
		}
	}

	@Override
	//��ѯmessage�����������ݷ���
	public List<Message> findAllMessage() {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Message> list = new ArrayList<>();
		String sql = "select * from tb_message";
		connection = (Connection) DbConnection.getConnection();//��ȡ����
		try {
			statement = (PreparedStatement) connection.prepareStatement(sql);
			resultSet = statement.executeQuery();//��ȡ��ѯ�����
			while(resultSet.next()){
				Message message = new Message();
				message.setMessageId(resultSet.getInt(1));//������Ϣid
				message.setMessageTitle(resultSet.getString(2));//���ñ���
				message.setMessageContent(resultSet.getString(3));//������Ϣ����
				message.setEmployeeId(resultSet.getInt(4));//�����û�id
				message.setPublishTime(resultSet.getDate(5));//���÷���ʱ��
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
