package com.hoaiduong.view.user;

import com.hoaiduong.domain.Parts;

public interface PartsViewHandle {
	
	public void createParts(Parts parts);
	public void deleteParts(Parts parts);
	public void updateList();
	public void setView(PartsView partsView);

}
