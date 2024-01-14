package com.sapient.BankApp.Dao;

import java.util.Optional;

import com.sapient.BankApp.model.Customer;

public interface BankingDao{
 
public Customer depositMoney(Customer cus, float amount);
public Customer withdrawMoney(Customer cus, float amount);

public boolean login(Customer cusList);

}
