package com.hoaiduong.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contract {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int contract_id;
	
	
	private String contract_code;
	private int contract_type;
	
	
	public int getContract_id() {
		return contract_id;
	}
	public void setContract_id(int contract_id) {
		this.contract_id = contract_id;
	}
	public String getContract_code() {
		return contract_code;
	}
	public void setContract_code(String contract_code) {
		this.contract_code = contract_code;
	}
	public int getContract_type() {
		return contract_type;
	}
	public void setContract_type(int contract_type) {
		this.contract_type = contract_type;
	}
	public Contract(int contract_id, String contract_code, int contract_type) {
		super();
		this.contract_id = contract_id;
		this.contract_code = contract_code;
		this.contract_type = contract_type;
	}
	public Contract(String contract_code, int contract_type) {
		super();
		this.contract_code = contract_code;
		this.contract_type = contract_type;
	}
	public Contract() {
		super();
	}
	
	
	
	
	
}
