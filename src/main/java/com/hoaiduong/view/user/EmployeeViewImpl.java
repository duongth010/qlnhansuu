package com.hoaiduong.view.user;

import java.util.List;

import com.hoaiduong.domain.Department;
import com.hoaiduong.domain.Employee;
import com.hoaiduong.domain.Parts;
import com.hoaiduong.presenter.DepartmentPresenter;
import com.hoaiduong.presenter.EmployeePresenter;
import com.vaadin.data.HasValue.ValueChangeEvent;
import com.vaadin.data.HasValue.ValueChangeListener;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

@SpringComponent
@UIScope
@SpringView
public class EmployeeViewImpl extends HorizontalLayout implements EmployeeView,View{
	
	public static final String VIEW_NAME="employee";
	EmployeePresenter employeePresenter;
	private Grid<Employee> grid;
	
	private TextField departmentName;
	
	
	private ComboBox<Department> parts;
	private Button save;
	private Button delete;
	private Button update;
	private Button addParts;
	private VerticalLayout allField;
	private Employee UpOrDelete;
	EmployeePresenter a;
	
	
	public void init() {
		initComponent();
		initListener();
		employeePresenter.updateView();
		employeePresenter.updateComponent();

		
	}
	
	private void initListener() {
		// TODO Auto-generated method stub
		grid.asSingleSelect().addValueChangeListener(new ValueChangeListener<Employee>() {

			@Override
			public void valueChange(ValueChangeEvent<Employee> event) {
				if (save.isVisible()) {
					save.setVisible(false);
				}

				if (!update.isVisible() && !delete.isVisible()) {
					update.setVisible(true);
					delete.setVisible(true);
				}

				
				if (event.getValue() == null)
				{
					allField.setVisible(false);
					UpOrDelete=event.getValue();
					departmentName.setValue("");
					
					
				}
					
				else {
					allField.setVisible(true);
					UpOrDelete=event.getValue();
					
//					departmentName.setValue(UpOrDelete.getDepartment_name());
//					parts.setValue(UpOrDelete.getParts());
					
				}

			}
		});

		addParts.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {

				grid.asSingleSelect().clear();

				if (update.isVisible() && delete.isVisible()) {
					update.setVisible(false);
					delete.setVisible(false);
				}

				if (!save.isVisible()) {
					save.setVisible(true);
				}

				
				if (!allField.isVisible()) {
					allField.setVisible(true);					
				} else
					allField.setVisible(false);
				
				
				

			}
		});
		
		save.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				if(!departmentName.getValue().equals("") && parts.getValue()!=null )
				{
//					employeePresenter.createDepartment(new Department(departmentName.getValue(),parts.getValue()));
					departmentName.setValue("");
					parts.setSelectedItem(null);
					
					allField.setVisible(false);
					
				}
				
				
				
			}
		});
		
		update.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				
				if(!departmentName.getValue().equals("") && parts.getValue()!=null ) {
//					UpOrDelete.setDepartment_name(departmentName.getValue());
//					UpOrDelete.setParts(parts.getValue());
//					employeePresenter.createDepartment(UpOrDelete);
					
				
					
					allField.setVisible(false);
					departmentName.setValue("");
					
				}
				
			}
		});
		
		
		
		delete.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				
				
				if(!departmentName.getValue().equals("") && parts.getValue()!=null ) {
//					employeePresenter.deleteDepartment(UpOrDelete);
				
					
					allField.setVisible(false);
					departmentName.setValue("");
				
				}
			}
		});
		
	}
	
	private void initComponent() {
		// TODO Auto-generated method stub
		grid = new Grid();
		grid.setCaption("List Parts");
	

		departmentName = new TextField("Department Name");
		parts=new ComboBox<>("Parts");
		

		allField = new VerticalLayout();
		allField.setSpacing(true);

		save = new Button("Save");
		delete = new Button("Delete");
		update = new Button("Update");
		addParts = new Button();
		addParts.setIcon(VaadinIcons.ADD_DOCK);

		HorizontalLayout allButton = new HorizontalLayout();
		allButton.setSpacing(true);
		allButton.addComponents(save, update, delete);

		allField.addComponents(departmentName,parts, allButton);

		allField.setVisible(false);

		addComponents(grid, addParts, allField);
		
	}

	@Override
	public void updateGrid(List<Employee> employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPresenter(EmployeePresenter employeePresenter) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void updateCombobox(List<Department> departments) {
		// TODO Auto-generated method stub
		
	}
	
	
}
