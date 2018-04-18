package com.hoaiduong.view.user;

import java.util.List;

import com.hoaiduong.domain.Contract;
import com.hoaiduong.presenter.ContractPresenter;

public interface ContractView {
	public void updateGrid(List<Contract> constracts);
	public void setPresenter(ContractPresenter contractPresenter);
}
