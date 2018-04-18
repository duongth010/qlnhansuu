package com.hoaiduong.view.user;

import java.util.List;

import com.hoaiduong.domain.Department;
import com.hoaiduong.domain.Employee;
import com.hoaiduong.presenter.EmployeePresenter;

public interface EmployeeView {
	
	public void updateGrid(List<Employee> employee);
	public void setPresenter(EmployeePresenter employeePresenter);
	void updateCombobox(List<Department> departments);
}
