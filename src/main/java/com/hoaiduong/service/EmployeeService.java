package com.hoaiduong.service;

import java.util.List;

import com.hoaiduong.domain.Department;
import com.hoaiduong.domain.Employee;

public interface EmployeeService {

	List<Employee> loadAll();

	List<Department> loadAllDepartment();

	void save(Employee employee);

	void delete(Employee employee);

}
