package com.hoaiduong.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Parts {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String parts_name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getParts_name() {
		return parts_name;
	}

	public void setParts_name(String parts_name) {
		this.parts_name = parts_name;
	}

	public Parts() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Parts(String parts_name) {
		super();
		this.parts_name = parts_name;
	}
	
	
	
	
}
