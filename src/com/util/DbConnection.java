package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbConnection {
    private static final String dbdriver= "com.mysql.jdbc.Driver";
    private static final String dburl = "jdbc:mysql://localhost:3306/companysys";
    private static final String user = "root";
    private static final String password = "052512";
    //�������ݿ�ķ���
    public static Connection getConnection(){
    	Connection connection = null;    //����һ�����Ӷ���
    	
    	try {
			Class.forName(dbdriver);
			try {
				connection = DriverManager.getConnection(dburl, user, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return connection;
    }
    //
    //�ر�����
    public static void close(Connection connection){
    	if(connection!=null)
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
    //�رս������
    public static void close(ResultSet rs){
    	if(rs!=null)
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
    //�ر�Ԥ�������
    public static void close(PreparedStatement pStatement){
    	if(pStatement!=null)
			try {
				pStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
}
