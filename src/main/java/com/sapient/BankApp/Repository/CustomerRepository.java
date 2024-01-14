package com.sapient.BankApp.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapient.BankApp.model.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
	 Optional<Customer> findByAadhar(String aadhar);
	 void deleteByAadhar(String aadhar);
	 Optional<Customer> findByEmail(String email);
}