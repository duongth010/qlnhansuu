package com.hoaiduong.view.user;

import com.hoaiduong.domain.Department;
import com.hoaiduong.domain.Employee;

public interface EmployeeViewHandle {
	public void setView(EmployeeView employeeView);
	public void create(Employee employee);
	public void delete(Employee employee);
	public void updateView();
	void updateComponent();
}
