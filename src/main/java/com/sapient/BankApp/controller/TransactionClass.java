package com.sapient.BankApp.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.sapient.BankApp.model.Transactions;

public class TransactionClass {
	
	 private String transaction_type;
	    private float amount;
	    private String customer_email;
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
		public String getCustomer_email() {
			return customer_email;
		}
		public void setCustomer_email(String customer_email) {
			this.customer_email = customer_email;
		}
	
	
}
	
	
