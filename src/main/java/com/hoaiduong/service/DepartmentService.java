package com.hoaiduong.service;

import java.util.List;

import com.hoaiduong.domain.Department;
import com.hoaiduong.domain.Parts;

public interface DepartmentService {

	void save(Department department);

	void delete(Department department);

	List<Department> loadAll();

	List<Parts> loadAllParts();

}
