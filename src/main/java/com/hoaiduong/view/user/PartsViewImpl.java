package com.hoaiduong.view.user;

import java.util.List;

import com.hoaiduong.domain.Parts;
import com.hoaiduong.presenter.PartsPresenter;
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
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@SpringComponent
@UIScope
@SpringView(name=PartsViewImpl.VIEW_NAME)
public class PartsViewImpl extends HorizontalLayout implements View,PartsView {
	/**
	 * 
	 */
	
	public static final String VIEW_NAME="parts";
	PartsPresenter partsPresenter;
	private Grid<Parts> grid;
	private TextField partsName;
	private Button save;
	private Button delete;
	private Button update;
	private Button addParts;
	private VerticalLayout allField;
	private Parts UpOrDelete;
	

	
	
	public void init() {
		initComponent();
		initListener();
		partsPresenter.updateList();

		
	}
	
	
	


	private void initListener() {
		// TODO Auto-generated method stub
		grid.asSingleSelect().addValueChangeListener(new ValueChangeListener<Parts>() {

			@Override
			public void valueChange(ValueChangeEvent<Parts> event) {
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
					partsName.setValue("");
					
					
				}
					
				else {
					allField.setVisible(true);
					UpOrDelete=event.getValue();
					partsName.setValue(UpOrDelete.getParts_name());
					
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
				if(!partsName.getValue().equals("") )
				{
					partsPresenter.createParts(new Parts(partsName.getValue()));
					partsName.setValue("");
					
					allField.setVisible(false);
					
				}
				
				
				
			}
		});
		
		update.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				
				if(!partsName.getValue().equals("") ) {
					UpOrDelete.setParts_name(partsName.getValue());
					
					partsPresenter.createParts(UpOrDelete);
					
				
					
					allField.setVisible(false);
					partsName.setValue("");
					
				}
				
			}
		});
		
		
		
		delete.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				
				
				if(!partsName.getValue().equals("")) {
					partsPresenter.deleteParts(UpOrDelete);
			
				
				allField.setVisible(false);
				partsName.setValue("");
				
				}
			}
		});
		
	}





	private void initComponent() {
		// TODO Auto-generated method stub
		grid = new Grid(Parts.class);
		grid.setCaption("List Parts");
	

		partsName = new TextField("Parts Name");
		

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

		allField.addComponents(partsName, allButton);

		allField.setVisible(false);

		addComponents(grid, addParts, allField);
		
	}





	@Override
	public void updateGrid(List<Parts> constracts) {
		
		grid.setItems(constracts);
	}





	public PartsPresenter getPartsPresenter() {
		return partsPresenter;
	}



	@Override
	public void setPresenter(PartsPresenter partsPresenter) {
		this.partsPresenter = partsPresenter;
	}



	


	
	
}
