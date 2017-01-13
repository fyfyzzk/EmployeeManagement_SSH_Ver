package com.muke.employee.action;

import com.muke.employee.domain.Employee;
import com.muke.employee.service.EmployeeService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/*
 * 
 * 员工管理的Action类
 * 
 * */

public class EmployeeAction extends ActionSupport implements ModelDriven<Employee> {
	//  模型驱动使用的对象
	private Employee employee = new Employee();
	
	@Override
	public Employee getModel() {

		return employee;
	}
	
	
	//  注入业务层类:
	
	private EmployeeService employeeService;
	
	/*登陆执行的方法
	 * 
	 * */
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public String login() {
		System.out.println("longin done!");
		
		
		return NONE;
	}
}
