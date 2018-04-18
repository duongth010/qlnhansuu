package com.hoaiduong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoaiduong.domain.Parts;
import com.hoaiduong.repository.PartsRepository;

@Service
public class PartsServiceImpl implements PartsService {
	@Autowired
	PartsRepository repository;

	@Override
	public void saveParts(Parts parts) {
		// TODO Auto-generated method stub
		repository.save(parts);
		
	}

	@Override
	public void deleteParts(Parts parts) {
		// TODO Auto-generated method stub
		repository.delete(parts);
		
	}

	@Override
	public List<Parts> loadAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
		
	}

}
