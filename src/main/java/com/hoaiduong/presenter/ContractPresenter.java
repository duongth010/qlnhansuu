package com.hoaiduong.presenter;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.hoaiduong.domain.Contract;
import com.hoaiduong.service.ContractService;
import com.hoaiduong.view.user.PartsView;
import com.hoaiduong.view.user.PartsViewImpl;
import com.hoaiduong.view.user.ContractView;
import com.hoaiduong.view.user.ContractViewHandle;
import com.hoaiduong.view.user.ContractViewImpl;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;

@SpringComponent
@UIScope
public class ContractPresenter implements ContractViewHandle {
	
	
	private ContractView contractView;
	
	@Autowired
	private ContractService service;
	
	public ContractPresenter() {
		
		
	}
	

	@Override
	@Transactional
	public void createContract(Contract contract) {
		service.save(contract);
		updateView();
		
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void deleteContract(Contract contract) {
		service.delete(contract);
		updateView();
		
	}

	@Override
	@Transactional
	public void updateView() {
		// TODO Auto-generated method stub
		contractView.updateGrid(service.loadAll());
		
	}


	public ContractView getContractView() {
		return contractView;
	}


	public void setView(ContractView contractView) {
		this.contractView = contractView;
	}


	
	

	


}


	


	
	
	


