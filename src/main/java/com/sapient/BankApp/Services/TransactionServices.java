package com.sapient.BankApp.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sapient.BankApp.model.Transactions;

@Service
public interface TransactionServices {
	
public List<Transactions> getAllTransactionsByAadhar(String aadhar);
public void addTransactions(Transactions Trans);

public List<Transactions> getAllTransactionsByEmail(String email);

}
