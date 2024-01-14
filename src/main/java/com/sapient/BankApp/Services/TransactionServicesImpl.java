package com.sapient.BankApp.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.BankApp.Dao.BankingDao;
import com.sapient.BankApp.Repository.TransactionsRepository;
import com.sapient.BankApp.model.Customer;
import com.sapient.BankApp.model.Transactions;

@Service
public class TransactionServicesImpl implements TransactionServices {
	
	@Autowired
	private TransactionsRepository TRepo;
	@Autowired
    private BankingServices bankingServices;
    
	@Autowired
	BankingDao Bdao;

	@Override
	public void addTransactions(Transactions Trans) {
		
		TRepo.save(Trans);
	}

	@Override
	public List<Transactions> getAllTransactionsByAadhar(String aadhar) {
		return TRepo.findByCus_Aadhar(aadhar);
}
	
	@Override
	public List<Transactions>  getAllTransactionsByEmail(String email){
		
		Customer cus = bankingServices.getCustomerByEmail(email);
		
		System.out.println(cus.getAadhar());
		return TRepo.findByCus_Aadhar(cus.getAadhar());
		//return null;
	}

}
