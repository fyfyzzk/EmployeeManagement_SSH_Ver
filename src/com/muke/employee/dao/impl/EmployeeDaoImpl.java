package com.muke.employee.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.muke.employee.dao.EmployeeDao;

public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {
	private EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
}
