package com.sapient.BankApp.Services;

import java.util.*;

import org.springframework.stereotype.Service;

import com.sapient.BankApp.model.Banking;
import com.sapient.BankApp.model.Customer;

@Service
public interface BankingServices {
	
		
public List<Customer> getAllCustomer();
public Customer depositMoney(Customer cus, float amount);
public Customer withdrawMoney(Customer cus, float amount);
public void addCustomer(Customer cus);
public Customer getCustomerByAadhar(String aadhar);
public void deleteCustomerByAadhar(String aadhar);
public Customer getCustomerByEmail(String email);
public void addBankingDetails(Banking b);	
	
public boolean login(Customer login);

}
