package com.muke.employee.service.impl;

import com.muke.employee.dao.EmployeeDao;
import com.muke.employee.service.EmployeeService;



/*
 * 
 * Employee implementation
 * */

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
}
