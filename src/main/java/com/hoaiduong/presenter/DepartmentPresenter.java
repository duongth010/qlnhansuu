package com.hoaiduong.presenter;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.hoaiduong.domain.Department;
import com.hoaiduong.service.DepartmentService;
import com.hoaiduong.view.user.DepartmentView;
import com.hoaiduong.view.user.DepartmentViewHandle;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;


@SpringComponent
@UIScope
public class DepartmentPresenter implements DepartmentViewHandle {

	private DepartmentView departmentView;
	
	@Autowired
	private DepartmentService service;
	
	
	@Override
	@Transactional
	public void createDepartment(Department department) {
		// TODO Auto-generated method stub
		service.save(department);
		updateView();
		
	}

	@Override
	public void setView(DepartmentView departmentView) {
		this.departmentView=departmentView;
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void deleteDepartment(Department department) {
		// TODO Auto-generated method stub
		service.delete(department);
		updateView();
		
	}

	@Override
	public void updateView() {
		// TODO Auto-generated method stub
		departmentView.updateGrid(service.loadAll());
		
	}
	
	@Override
	public void updateComponent() {
		departmentView.updateCombobox(service.loadAllParts());
	}
	
	

}
