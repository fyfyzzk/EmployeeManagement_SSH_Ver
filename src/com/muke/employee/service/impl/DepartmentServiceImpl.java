package com.muke.employee.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.muke.employee.dao.DepartmentDao;
import com.muke.employee.domain.Department;
import com.muke.employee.domain.PageBean;
import com.muke.employee.service.DepartmentService;
//Impl class for Department Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
	//  inject a department Dao
	
	private DepartmentDao departmentDao;

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	@Override
	public PageBean<Department> findByPage(Integer currPage) {
		PageBean<Department> pageBean = new PageBean<Department>();
		
		//	fengzhuang dangqian ye
		pageBean.setCurrPage(currPage);
		//	fengzhuang meiye xianshi jilu shu;
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		//  fengzhuang zong jilu shu
		int totalCount = departmentDao.findCount();
		pageBean.setTotalCount(totalCount);
		//	fengzhuang zong ye shu
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		//  fengzhuang meiye xianshi shuju
		int begin = (currPage - 1) * pageSize;
		List<Department> list = departmentDao.findByPage(begin, pageSize);
		
		for (Department t : list) {
			System.out.println(" DepartmentServiceImpl    list name : " + t.getDname());
		}
		
		
		pageBean.setList(list);
		
		
		
		
		return pageBean;
	}

	@Override
	//	Service to save department method
	public void save(Department department) {
		// TODO Auto-generated method stub
		departmentDao.save(department);
	}

	@Override
	public Department findById(Integer did) {
		
		return departmentDao.findById(did);
	}

	@Override
	//	业务曾修改部门的方法
	public void update(Department department) {
		departmentDao.update(department);
	}

	@Override
	//	service layer delete department function
	public void delete(Department department) {
		// TODO Auto-generated method stub
		departmentDao.delete(department);
	}

	@Override
	//	to get all the department
	public List<Department> findAll() {
		
		return departmentDao.findAll();
	}
}
