package com.hoaiduong.view.user;

import java.util.List;

import com.hoaiduong.domain.Department;
import com.hoaiduong.domain.Parts;
import com.hoaiduong.presenter.DepartmentPresenter;

public interface DepartmentView {
	public void setPresenter(DepartmentPresenter departmentPresenter);

	void updateGrid(List<Department> department);

	void updateCombobox(List<Parts> parts);
}
