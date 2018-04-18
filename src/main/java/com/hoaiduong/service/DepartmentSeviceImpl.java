package com.hoaiduong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoaiduong.domain.Department;
import com.hoaiduong.domain.Parts;
import com.hoaiduong.repository.DepartmentRepository;
import com.hoaiduong.repository.PartsRepository;

@Service
public class DepartmentSeviceImpl implements DepartmentService {
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Autowired
	PartsRepository partsRepository;
	
	@Override
	public void save(Department department) {
		departmentRepository.save(department);
	}
	
	@Override
	public void delete(Department department) {
		departmentRepository.delete(department);
	}
	
	@Override
	public List<Department> loadAll() {
		return departmentRepository.findAll();
	}
	
	@Override
	public List<Parts> loadAllParts(){
		return partsRepository.findAll();
	}
	
	
	
	
}
