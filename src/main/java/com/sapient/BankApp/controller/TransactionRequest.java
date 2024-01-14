package com.sapient.BankApp.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.sapient.BankApp.model.Transactions;

public class TransactionRequest {
	
	 private String transaction_type;
	    private float amount;
	    private String email;
		public String getTransaction_type() {
			return transaction_type;
		}
		public void setTransaction_type(String transaction_type) {
			this.transaction_type = transaction_type;
		}
		public float getAmount() {
			return amount;
		}
		public void setAmount(float amount) {
			this.amount = amount;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		
	
	
}
	
	
