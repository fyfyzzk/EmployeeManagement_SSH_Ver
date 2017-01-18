package com.muke.employee.service;


import com.muke.employee.domain.Department;
import com.muke.employee.domain.PageBean;

public interface DepartmentService {

	PageBean<Department> findByPage(Integer currPage);

	void save(Department department);
	
}
