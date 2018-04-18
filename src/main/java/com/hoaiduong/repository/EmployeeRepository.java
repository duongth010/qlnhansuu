package com.hoaiduong.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hoaiduong.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
