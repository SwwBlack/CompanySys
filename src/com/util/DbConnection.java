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
    //链接数据库的方法
    public static Connection getConnection(){
    	Connection connection = null;    //声明一个连接对象
    	
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
    //关闭连接
    public static void close(Connection connection){
    	if(connection!=null)
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
    //关闭结果对象集
    public static void close(ResultSet rs){
    	if(rs!=null)
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
    //关闭预处理对象
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
