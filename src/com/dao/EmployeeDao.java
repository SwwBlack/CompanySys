package com.dao;

import java.util.List;

import com.bean.Employee;

public interface EmployeeDao {
     public void addEmployee(Employee employee);//���Ա����Ϣ
     public void updateEmployee(Employee employee);//�޸�Ա����Ϣ
     public void delEmployee(int employeeId);//ɾ��Ա����Ϣ
     public List<Employee> findAllemployee();//��ѯ����Ա����Ϣ
     public Employee findEmployeeById(int employeeId);//ͨ��id��ѯԱ����Ϣ    
}    	 
