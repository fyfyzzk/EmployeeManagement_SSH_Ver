package com.muke.employee.action;

import com.muke.employee.domain.Department;
import com.muke.employee.domain.PageBean;
import com.muke.employee.service.DepartmentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/*  Department Action class*/
public class DepartmentAction extends ActionSupport implements ModelDriven<Department>{
	//  Object used by Model driven 
	private Department department = new Department();
	@Override
	public Department getModel() {
		return department;
	}
	
	private Integer currPage = 1;

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	
	//	inject a department management service
	private DepartmentService departmentService;
	
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	//	provide a method for requesting checkout
	public String findAll() {
		PageBean<Department> pageBean = departmentService.findByPage(currPage);
		//	save pageBean into valueStack
		for (Department d : pageBean.getList()) {
			System.out.println("  DepartmentAction : " + d.getdName());
		}

		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}

	//	jump to addDepartment
	public String saveUI() {
		return "saveUI";
	}
	
	//	add method of addDepartment
	public String save() {
		departmentService.save(department);
		return "saveSuccess";
	}
}
