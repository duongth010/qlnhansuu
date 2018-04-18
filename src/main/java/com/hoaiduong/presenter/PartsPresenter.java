package com.hoaiduong.presenter;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.hoaiduong.domain.Parts;
import com.hoaiduong.service.PartsService;
import com.hoaiduong.view.user.PartsView;
import com.hoaiduong.view.user.PartsViewHandle;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;

@SpringComponent
@UIScope
public class PartsPresenter implements PartsViewHandle {
	private PartsView partsView;
	
	@Autowired
	private PartsService service;

	public PartsPresenter() {
		
	}



	@Override
	@Transactional
	public void createParts(Parts parts) {
		// TODO Auto-generated method stub
		service.saveParts(parts);
		updateList();
		
	}



	@Override
	@Transactional
	public void deleteParts(Parts parts) {
		// TODO Auto-generated method stub
		service.deleteParts(parts);
		updateList();
		
	}



	@Override
	public void updateList() {
		// TODO Auto-generated method stub
		partsView.updateGrid(service.loadAll());
	}



	public PartsView getPartsView() {
		return partsView;
	}


	@Override
	public void setView(PartsView partsView) {
		this.partsView = partsView;
	}
	
	
	
	
	
	
	
	
	
	
	
}
