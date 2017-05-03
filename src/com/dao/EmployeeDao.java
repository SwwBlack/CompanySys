package com.dao;

import java.util.List;

import com.bean.Employee;

public interface EmployeeDao {
     public void addEmployee(Employee employee);//添加员工信息
     public void updateEmployee(Employee employee);//修改员工信息
     public void delEmployee(int employeeId);//删除员工信息
     public List<Employee> findAllemployee();//查询所有员工信息
     public Employee findEmployeeById(int employeeId);//通过id查询员工信息    
}    	 
