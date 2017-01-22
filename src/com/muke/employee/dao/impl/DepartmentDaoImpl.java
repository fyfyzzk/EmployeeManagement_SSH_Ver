package com.muke.employee.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.muke.employee.dao.DepartmentDao;
import com.muke.employee.domain.Department;

public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {

	@Override
	public int findCount() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Department";
		List<Long> list = this.getHibernateTemplate().find(hql);
		
		if (list.size() > 0) {
			return list.get(0).intValue();
		}
		
		return 0;
	}

	@Override
	//	fenye cha xun bumen
	public List<Department> findByPage(int begin, int pageSize) {
		// TODO Auto-generated method stub
		//	what is this
		DetachedCriteria criteria = DetachedCriteria.forClass(Department.class);	//	reflection
		
		List<Department> list = this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		
		System.out.println(" DepartmentDaoImpl    list : " + list);
		
		for (Department t : list) {
			System.out.println(" DepartmentDaoImpl    list name : " + t.getDname());
		}
		
		return list;
	}

	@Override
	public void save(Department department) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(department);
	}

	@Override
	//	find department by department id
	public Department findById(Integer did) {
		return this.getHibernateTemplate().get(Department.class, did);
	}

	@Override
	//	Dao modify department method
	public void update(Department department) {
		this.getHibernateTemplate().update(department);
	}

}
