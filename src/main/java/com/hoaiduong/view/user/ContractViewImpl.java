package com.hoaiduong.view.user;

import java.util.List;

import com.hoaiduong.domain.Contract;
import com.hoaiduong.presenter.ContractPresenter;
import com.vaadin.data.HasValue.ValueChangeEvent;
import com.vaadin.data.HasValue.ValueChangeListener;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
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
@SpringComponent
@UIScope
@SpringView(name = ContractViewImpl.VIEW_NAME)
public class ContractViewImpl extends HorizontalLayout implements View,ContractView {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String VIEW_NAME = "contract";
	private ContractPresenter contractPresenter;
	private Grid<Contract> grid;
	private TextField contractCode;
	private TextField contractType;
	private Button save;
	private Button delete;
	private Button update;
	private Button addContract;
	private VerticalLayout allField;
	private Contract UpOrDelete;
	

	
	public void init() {
		initComponent();
		initListener();
		contractPresenter.updateView();
		
		
	}

	

	private void initListener() {
		grid.asSingleSelect().addValueChangeListener(new ValueChangeListener<Contract>() {

			@Override
			public void valueChange(ValueChangeEvent<Contract> event) {
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
					contractCode.setValue("");
					contractType.setValue("");
					
				}
					
				else {
					allField.setVisible(true);
					UpOrDelete=event.getValue();
					contractCode.setValue(UpOrDelete.getContract_code());
					contractType.setValue(String.valueOf(UpOrDelete.getContract_type()));
				}

			}
		});

		addContract.addClickListener(new ClickListener() {

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
				if(!contractCode.getValue().equals("") && !contractType.getValue().equals("") /*&& !contractId.getValue().equals("")*/)
				{
					contractPresenter.createContract(new Contract(contractCode.getValue(),Integer.parseInt(contractType.getValue())));
					contractCode.setValue("");
					contractType.setValue("");
					allField.setVisible(false);
					
				}
				
				
				
			}
		});
		
		update.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				
				if(!contractCode.getValue().equals("") && !contractType.getValue().equals("") /*&& !contractId.getValue().equals("")*/) {
					UpOrDelete.setContract_code(contractCode.getValue());
					UpOrDelete.setContract_type(Integer.parseInt(contractType.getValue()));
					contractPresenter.createContract(UpOrDelete);
					
				
					
					allField.setVisible(false);
					contractCode.setValue("");
					contractType.setValue("");
				}
				
			}
		});
		
		
		
		delete.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				
				
				if(!contractCode.getValue().equals("") && !contractType.getValue().equals("") /*&& !contractId.getValue().equals("")*/) {
					contractPresenter.deleteContract(UpOrDelete);
			
				
				allField.setVisible(false);
				contractCode.setValue("");
				contractType.setValue("");
				}
			}
		});
		
		
	}

	private void initComponent() {
		
		grid = new Grid(Contract.class);
		grid.setCaption("List Contract");
	

		contractCode = new TextField("Contract Code");
		contractType = new TextField("Contract Type");
		//contractId = new TextField("Contract Id");

		allField = new VerticalLayout();
		allField.setSpacing(true);

		save = new Button("Save");
		delete = new Button("Delete");
		update = new Button("Update");
		addContract = new Button();
		addContract.setIcon(VaadinIcons.ADD_DOCK);

		HorizontalLayout allButton = new HorizontalLayout();
		allButton.setSpacing(true);
		allButton.addComponents(save, update, delete);

		allField.addComponents(contractCode, contractType, allButton);

		allField.setVisible(false);

		addComponents(grid, addContract, allField);

	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		View.super.enter(event);
	}



	@Override
	public void updateGrid(List<Contract> constracts) {
		
		grid.setItems(constracts);
		
	}



	public ContractPresenter getContractPresenter() {
		return contractPresenter;
	}


	@Override
	public void setPresenter(ContractPresenter contractPresenter) {
		this.contractPresenter = contractPresenter;
	}


}
