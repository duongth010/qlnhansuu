package com.hoaiduong.service;

import java.util.List;

import com.hoaiduong.domain.Parts;

public interface PartsService {
	public void saveParts(Parts parts);
	public void deleteParts(Parts parts);
	public List<Parts> loadAll();

}
