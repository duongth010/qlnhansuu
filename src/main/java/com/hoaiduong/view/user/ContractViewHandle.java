package com.hoaiduong.view.user;

import com.hoaiduong.domain.Contract;

public interface ContractViewHandle {
	public void createContract(Contract contract);
	public void deleteContract(Contract contract);
	public void updateView();
	public void setView(ContractView contractView);
	
	
}
