package com.bean;

import java.sql.Date;

public class Criticism {
    //
	private int criticismId;
	private String criticismContent;
	private int employeeId;
	private int messageId;
	private Date criticismTime;
	//
	public int getCriticismId() {
		return criticismId;
	}
	public void setCriticismId(int criticismId) {
		this.criticismId = criticismId;
	}
	public String getCriticismContent() {
		return criticismContent;
	}
	public void setCriticismContent(String criticismContent) {
		this.criticismContent = criticismContent;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public Date getCriticismTime() {
		return criticismTime;
	}
	public void setCriticismTime(Date criticismTime) {
		this.criticismTime = criticismTime;
	}
	
}
