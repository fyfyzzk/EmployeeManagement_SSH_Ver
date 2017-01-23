package com.muke.employee.dao;

import java.util.List;

import com.muke.employee.domain.Employee;



/*
 * Employee management  DAO
 * 
 * */

public interface EmployeeDao {

	Employee findByUsernameAndPassword(Employee employee);

	List<Employee> findByPage(int begin, int pageSize);

	int findCount();

}
