package com.hoaiduong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoaiduong.domain.Contract;
import com.hoaiduong.repository.ContractRepository;
@Service
public class ContractServiceImpl implements ContractService{
	
	@Autowired
	ContractRepository repository;

	@Override
	public void save(Contract contract) {
		// TODO Auto-generated method stub
		repository.save(contract);
		
	}

	@Override
	public void update(Contract contract) {
		// TODO Auto-generated method stub
//		Contract update=repository.findById(contract.getContract_id()).get();
		
		repository.save(contract);
		
		
	}

	@Override
	public void delete(Contract contract) {
		// TODO Auto-generated method stub
		repository.deleteById(contract.getContract_id());
	}

	@Override
	public List<Contract> loadAll() {
		// TODO Auto-generated method stub
		
		return repository.findAll();
	}
	
}
