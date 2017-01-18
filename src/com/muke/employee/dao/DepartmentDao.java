package com.muke.employee.dao;

import java.util.List;

import com.muke.employee.domain.Department;

public interface DepartmentDao {
	int findCount();
	List<Department> findByPage(int begin, int pageSize);
	void save(Department department);
}
