package com.hoaiduong.view.user;

import java.util.List;

import com.hoaiduong.domain.Department;
import com.hoaiduong.domain.Parts;
import com.hoaiduong.presenter.DepartmentPresenter;
import com.vaadin.data.HasValue.ValueChangeEvent;
import com.vaadin.data.HasValue.ValueChangeListener;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
@SpringComponent
@UIScope
@SpringView(name=DepartmentViewImpl.VIEW_NAME)
public class DepartmentViewImpl extends HorizontalLayout implements DepartmentView,View {
	public static final String VIEW_NAME="department";
	DepartmentPresenter deppartmentPresenter;
	private Grid<Department> grid;
	private TextField departmentName;
	private ComboBox<Parts> parts;
	private Button save;
	private Button delete;
	private Button update;
	private Button addParts;
	private VerticalLayout allField;
	private Department UpOrDelete;
	
	
	public void init() {
		initComponent();
		initListener();
		deppartmentPresenter.updateView();
		deppartmentPresenter.updateComponent();

		
	}
	
	private void initListener() {
		// TODO Auto-generated method stub
		grid.asSingleSelect().addValueChangeListener(new ValueChangeListener<Department>() {

			@Override
			public void valueChange(ValueChangeEvent<Department> event) {
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
					departmentName.setValue(UpOrDelete.getDepartment_name());
					parts.setValue(UpOrDelete.getParts());
					
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
					deppartmentPresenter.createDepartment(new Department(departmentName.getValue(),parts.getValue()));
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
					UpOrDelete.setDepartment_name(departmentName.getValue());
					UpOrDelete.setParts(parts.getValue());
					deppartmentPresenter.createDepartment(UpOrDelete);
					
				
					
					allField.setVisible(false);
					departmentName.setValue("");
					
				}
				
			}
		});
		
		
		
		delete.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				
				
				if(!departmentName.getValue().equals("") && parts.getValue()!=null ) {
					deppartmentPresenter.deleteDepartment(UpOrDelete);
				
					
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
	public void setPresenter(DepartmentPresenter departmentPresenter) {
		this.deppartmentPresenter=departmentPresenter;
		
		
	}
	
	@Override
	public void updateGrid(List<Department> department) {
		this.grid.setItems(department);
		this.grid.addColumn(Department::getDepartment_name).setCaption("Department_Name");
		this.grid.addColumn(Department::getPartsName).setCaption("Part_Name");
	}
	
	@Override
	public void updateCombobox(List<Parts> parts) {
		this.parts.setItems(parts);
		this.parts.setItemCaptionGenerator(Parts::getParts_name);
		
	}
	
	
	
	
}
