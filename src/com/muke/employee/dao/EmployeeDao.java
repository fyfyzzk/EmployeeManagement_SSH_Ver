package com.muke.employee.dao;

import com.muke.employee.domain.Employee;


/*
 * Employee management  DAO
 * 
 * */

public interface EmployeeDao {

	Employee findByUsernameAndPassword(Employee employee);

}
