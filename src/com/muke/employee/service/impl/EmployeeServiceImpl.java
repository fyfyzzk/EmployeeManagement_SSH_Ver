package com.muke.employee.service.impl;

import com.muke.employee.dao.EmployeeDao;
import com.muke.employee.domain.Employee;
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

	@Override
	public Employee login(Employee employee) {
		// TODO Auto-generated method stub
		Employee existEmployee = employeeDao.findByUsernameAndPassword(employee);
		return existEmployee;
	}
	
}
