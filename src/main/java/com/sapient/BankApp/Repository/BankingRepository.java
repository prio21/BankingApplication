package com.sapient.BankApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sapient.BankApp.model.Banking;


public interface BankingRepository extends JpaRepository<Banking,String>{

}
