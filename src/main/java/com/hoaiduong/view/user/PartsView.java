package com.hoaiduong.view.user;

import java.util.List;

import com.hoaiduong.domain.Parts;
import com.hoaiduong.presenter.PartsPresenter;

public interface PartsView {
	public void updateGrid(List<Parts> parts);
	public void setPresenter(PartsPresenter partsPresenter);
}
