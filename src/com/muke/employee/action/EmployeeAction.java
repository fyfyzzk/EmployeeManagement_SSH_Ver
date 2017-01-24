package com.muke.employee.action;

import java.util.List;

import com.muke.employee.domain.Department;
import com.muke.employee.domain.Employee;
import com.muke.employee.domain.PageBean;
import com.muke.employee.service.DepartmentService;
import com.muke.employee.service.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
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
	//  当前页数
	private Integer currPage = 1;
	//  注入业务层类:
	private EmployeeService employeeService;
	private DepartmentService departmentService;

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	@Override
	public Employee getModel() {
		return employee;
	}

	/*登陆执行的方法
	 * 
	 * */
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public String login() {
		System.out.println("longin done!");
		//  call service class
		
		Employee existEmployee = employeeService.login(employee);
		
		if (existEmployee == null) {
			//	login fail
			this.addActionError("用户名或密码错误");
			return INPUT;
		} else {
			//	login succeed
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);
			return SUCCESS;
		}
	}
	
	//	check out employees infor method
	public String findAll() {
		PageBean<Employee> pageBean = employeeService.findByPage(currPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		
		return "findAll";
	}
	
	//	jump to add new page
	public String saveUI() {
		//	check out all the department
		List<Department> list = departmentService.findAll();
		//	??  collection use set  while object use push?
		ActionContext.getContext().getValueStack().set("list", list);
		return "saveUI";
	}
	
	public String save() {
		//	??	when I input wrong date type, it will directly go to the login page?
		employeeService.save(employee);
		return "saveSuccess";
	}
	
	//	edit employee method
	public String edit() {
		//	check by id
		employee = employeeService.findById(employee.getEid());
		//	also check all the departments
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		
		return "editSuccess";
	}

	//	modify employee method
	public String update() {
		employeeService.update(employee);
		return "updateSuccess";
	}
}
