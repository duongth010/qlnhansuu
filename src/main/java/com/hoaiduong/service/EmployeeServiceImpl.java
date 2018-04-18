package com.hoaiduong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoaiduong.domain.Department;
import com.hoaiduong.domain.Employee;
import com.hoaiduong.repository.DepartmentRepository;
import com.hoaiduong.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository repository;

	@Autowired
	DepartmentRepository departmentRepository;

	@Override
	public List<Employee> loadAll() {
		return repository.findAll();
	}

	@Override
	public List<Department> loadAllDepartment() {
		return departmentRepository.findAll();
	}

	@Override
	public void save(Employee employee) {
		repository.save(employee);
	}

	@Override
	public void delete(Employee employee) {
		repository.delete(employee);
	}

}
