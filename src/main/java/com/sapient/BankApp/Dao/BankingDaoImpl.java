package com.sapient.BankApp.Dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sapient.BankApp.Repository.CustomerRepository;
import com.sapient.BankApp.model.Customer;



@Repository
public class BankingDaoImpl implements BankingDao{


	@Autowired
	CustomerRepository CusRepo;
	
	@Override
	public Customer depositMoney(Customer cus, float amount) {
		
		float finalAmount = cus.getBalance() + amount;
		cus.setBalance(finalAmount);
		return cus;
		
	}

	@Override
	public Customer withdrawMoney(Customer cus, float amount) {

		float bal = cus.getBalance() - amount;
		cus.setBalance(bal);
		return cus;
	}

	
	@Override
	public boolean login(Customer login) {
		
		Optional<Customer> customer = CusRepo.findByEmail(login.getEmail());
		 return customer.isPresent() && customer.get().getPassword().equals(login.getPassword());
		
	}
	


}
