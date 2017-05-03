package com.bean;

import java.sql.Date;

public class Employee {
    //
	private int employeeId;
	private String employeeName;
	private int employeeSex;
	private Date employeeBirth;
	private String employeePhone;
	private String employeePlace;
	private Date joinTime;
	private String password;
	private int isLead;
	//setter  and  getter
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public int getEmployeeSex() {
		return employeeSex;
	}
	public void setEmployeeSex(int employeeSex) {
		this.employeeSex = employeeSex;
	}
	public Date getEmployeeBirth() {
		return employeeBirth;
	}
	public void setEmployeeBirth(Date employeeBirth) {
		this.employeeBirth = employeeBirth;
	}
	public String getEmployeePhone() {
		return employeePhone;
	}
	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}
	public String getEmployeePlace() {
		return employeePlace;
	}
	public void setEmployeePlace(String employeePlace) {
		this.employeePlace = employeePlace;
	}
	public Date getJoinTime() {
		return joinTime;
	}
	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getIsLead() {
		return isLead;
	}
	public void setIsLead(int isLead) {
		this.isLead = isLead;
	}
	
}
