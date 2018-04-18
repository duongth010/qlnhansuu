package com.hoaiduong.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hoaiduong.domain.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
