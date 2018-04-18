package com.hoaiduong.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
		
	private String emp_name;
	
	private Date emp_dob;
	
	private int emp_sex;
	
	private String emp_number_insurance;
	
	private String emp_address;
	
	private String emp_phone;
	
	private int emp_type;
	
	@OneToOne
	private Department department_id;
	
	


	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getEmp_name() {
		return emp_name;
	}




	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}




	public Date getEmp_dob() {
		return emp_dob;
	}




	public void setEmp_dob(Date emp_dob) {
		this.emp_dob = emp_dob;
	}




	public int getEmp_sex() {
		return emp_sex;
	}




	public void setEmp_sex(int emp_sex) {
		this.emp_sex = emp_sex;
	}




	public String getEmp_number_insurance() {
		return emp_number_insurance;
	}




	public void setEmp_number_insurance(String emp_number_insurance) {
		this.emp_number_insurance = emp_number_insurance;
	}




	public String getEmp_address() {
		return emp_address;
	}




	public void setEmp_address(String emp_address) {
		this.emp_address = emp_address;
	}




	public String getEmp_phone() {
		return emp_phone;
	}




	public void setEmp_phone(String emp_phone) {
		this.emp_phone = emp_phone;
	}




	public int getEmp_type() {
		return emp_type;
	}




	public void setEmp_type(int emp_type) {
		this.emp_type = emp_type;
	}




	public Department getDepartment_id() {
		return department_id;
	}




	public void setDepartment_id(Department department_id) {
		this.department_id = department_id;
	}




	public Employee(String emp_name, Date emp_dob, int emp_sex, String emp_number_insurance, String emp_address,
			String emp_phone, int emp_type, Department department_id) {
		super();
		this.emp_name = emp_name;
		this.emp_dob = emp_dob;
		this.emp_sex = emp_sex;
		this.emp_number_insurance = emp_number_insurance;
		this.emp_address = emp_address;
		this.emp_phone = emp_phone;
		this.emp_type = emp_type;
		this.department_id = department_id;
	}




	public Employee() {
		super();
		
	}
	
	
	
	
	
	
}
