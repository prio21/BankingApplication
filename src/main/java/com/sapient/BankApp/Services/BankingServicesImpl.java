package com.sapient.BankApp.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.BankApp.Dao.BankingDao;
import com.sapient.BankApp.Repository.BankingRepository;
import com.sapient.BankApp.Repository.CustomerRepository;
import com.sapient.BankApp.model.Banking;
import com.sapient.BankApp.model.Customer;


@Service
public class BankingServicesImpl implements BankingServices {
	
	
	@Autowired
	BankingDao Bdao;
	
	@Autowired
	CustomerRepository CusRepo;
	
	@Autowired
	BankingRepository bank;

	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> cusList = CusRepo.findAll();
		for(Customer c:cusList) {
			System.out.println(c.getRole().name());
		}
		System.out.print(cusList);
		return cusList;
	}

	@Override
	public Customer depositMoney(Customer cus, float amount) {
		Customer localCus = Bdao.depositMoney(cus, amount);
		CusRepo.save(localCus);
		return localCus;
	}

	@Override
	public Customer withdrawMoney(Customer cus, float amount) {
		Customer localCus = Bdao.withdrawMoney(cus, amount);
		CusRepo.save(localCus);
		return localCus;
	}

	@Override
	public void addCustomer(Customer cus) {
		CusRepo.save(cus);
		
	}

   @Override
	public Customer getCustomerByAadhar(String aadhar) {
	 	   return CusRepo.findById(aadhar).orElse(null);
   }

   
   @Override
   public Customer getCustomerByEmail(String email) {
	   return CusRepo.findByEmail(email).orElse(null);
   }
   
   
	@Override
	public void deleteCustomerByAadhar(String aadhar) {
	 CusRepo.deleteById(aadhar);
	}
	
	@Override 
	public void addBankingDetails(Banking b) {
		bank.save(b);
	}
	
	@Override
	public boolean login(Customer login) {
		
	 return Bdao.login(login);
	 	  
		
	}


}
