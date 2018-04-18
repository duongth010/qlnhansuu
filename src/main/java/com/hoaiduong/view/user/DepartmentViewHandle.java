package com.hoaiduong.view.user;

import com.hoaiduong.domain.Department;

public interface DepartmentViewHandle {
	public void setView(DepartmentView departmentView);
	public void createDepartment(Department department);
	public void deleteDepartment(Department department);
	public void updateView();
	void updateComponent();
}
