package com.muke.employee.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.muke.employee.dao.EmployeeDao;
import com.muke.employee.domain.Employee;

public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {
	private EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public Employee findByUsernameAndPassword(Employee employee) {
		// TODO Auto-generated method stub
		
		String hql = "from Employee where username = ? and password = ?";
		List<Employee> list = this.getHibernateTemplate().find(hql, employee.getUsername(), employee.getPassword());
		
		System.out.println("findByUsernameAndPassword :  size " + list.size() + " username : " + employee.getUsername() + " password : " + employee.getPassword());
		
		if (list.size() > 0) {
			return list.get(0);
		}
		
		return null;
	}

	@Override
	public List<Employee> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
		List<Employee> list = this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		
		return list;
	}

	@Override
	public int findCount() {
		String hql = "select count(*) from Employee";
		List<Long> list = this.getHibernateTemplate().find(hql);
		
		if (list.size() > 0) {
			return list.get(0).intValue();
		}
		
		return 0;
	}

	@Override
	//	DAO: save a employee
	public void save(Employee employee) {
		this.getHibernateTemplate().save(employee);
	}

	@Override
	//	check out employee by id
	public Employee findById(Integer eid) {
		return this.getHibernateTemplate().get(Employee.class, eid);
	}

	@Override
	public void update(Employee employee) {
		this.getHibernateTemplate().update(employee);
	}
	
}
