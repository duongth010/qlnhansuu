package com.hoaiduong.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Department {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String department_name;
	
	@OneToOne
	@JoinColumn(name="parts_id")
	private Parts parts;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public Parts getParts() {
		return parts;
	}

	public void setParts(Parts parts) {
		this.parts = parts;
	}

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(String department_name, Parts parts) {
		super();
		this.department_name = department_name;
		this.parts = parts;
	}
	
	public String getPartsName() {
		
		return parts.getParts_name();
	}
	
	
	
	
	
	
}
