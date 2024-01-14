package com.sapient.BankApp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sapient.BankApp.model.Transactions;

public interface TransactionsRepository extends JpaRepository<Transactions, Long>{
	List<Transactions> findByCus_Aadhar(String aadhar);
}
