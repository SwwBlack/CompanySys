package com.factory;

import com.daoImpl.EmployeeDaoImpl;

public class EmployeeDaoImplFactory {
    public  static EmployeeDaoImpl getEmployeeDaoImpl(){
    	return new EmployeeDaoImpl();
    }
}
