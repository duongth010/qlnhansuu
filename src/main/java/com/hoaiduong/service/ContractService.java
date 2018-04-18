package com.hoaiduong.service;

import java.util.List;

import com.hoaiduong.domain.Contract;

public interface ContractService {
	public void save(Contract contract);
	public void update(Contract contract);
	public void delete(Contract contract);
	public List<Contract> loadAll();
}
