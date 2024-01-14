package com.sapient.BankApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="banking_table")
public class Banking {
	
	@Id
	private String aadhar;
	private String loan_type;
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}
	public String getLoan_type() {
		return loan_type;
	}
	public void setLoan_type(String loan_type) {
		this.loan_type = loan_type;
	}
	
	
	public Banking(String aadhar, String loan_type) {
		super();
		this.aadhar = aadhar;
		this.loan_type = loan_type;
	}
	
	

}
