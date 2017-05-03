package com.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.bean.Employee;
import com.dao.EmployeeDao;
import com.mysql.jdbc.PreparedStatement;
import com.util.DbConnection;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delEmployee(int employeeId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Employee> findAllemployee() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	//通过id查找用户方法
	public Employee findEmployeeById(int employeeId) {
		// TODO Auto-generated method stub
		Connection connection = DbConnection.getConnection();
		String sqlString = "select * from tb_employee where employeeId=?";
		PreparedStatement statement = null;//声明预处理对象
		ResultSet resultSet = null;//声明结果集
		Employee employee = null;
		try {
			statement = (PreparedStatement) connection.prepareStatement(sqlString);
			statement.setInt(1, employeeId);
			resultSet = statement.executeQuery();
			if(resultSet.next()){
			    employee = new Employee();
				employee.setEmployeeId(resultSet.getInt(1));
				employee.setEmployeeName(resultSet.getString(2));
				employee.setEmployeeSex(resultSet.getInt(3));
				employee.setEmployeeBirth(resultSet.getDate(4));
				employee.setEmployeePhone(resultSet.getString(5));
				employee.setEmployeePlace(resultSet.getString(6));
				employee.setJoinTime(resultSet.getDate(7));
				employee.setPassword(resultSet.getString(8));
				employee.setIsLead(resultSet.getInt(9));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbConnection.close(connection);
			DbConnection.close(statement);
			DbConnection.close(resultSet);
		}
	  return employee;
	}

}
