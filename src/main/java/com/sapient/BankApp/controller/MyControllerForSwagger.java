package com.sapient.BankApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sapient.BankApp.Services.BankingServices;
import com.sapient.BankApp.Services.TransactionServices;
import com.sapient.BankApp.model.Customer;
import com.sapient.BankApp.model.Transactions;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/customer")
public class MyControllerForSwagger {
    @Autowired
    private BankingServices bankingServices;
    
    @Autowired
    private TransactionServices Tservice;

    @GetMapping("/getCustomer")
    public List<Customer> getCustomer() {
        return bankingServices.getAllCustomer();
    }
    
    @GetMapping("/getTransactionhistoryByAadhar/{aadhar}")
    public List<Transactions> getTransactions(@PathVariable("aadhar") String aadhar){
      return Tservice.getAllTransactionsByAadhar(aadhar);
    }
    @GetMapping("/getCustomerByAadhar/{aadhar}")
    public ResponseEntity<Customer> getCustomerByAadhar(@PathVariable("aadhar") String aadhar) {
        try {
            Customer customer = bankingServices.getCustomerByAadhar(aadhar);

            if (customer != null) {
                return new ResponseEntity<>(customer, HttpStatus.OK);
            } else {
                System.out.println("Customer not found for Aadhar: " + aadhar);
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping("/addTransactions")
    public ResponseEntity<Transactions> insertTransactions(@RequestBody Transactions Trans) {
    	try {
    		Tservice.addTransactions(Trans);
    		return new ResponseEntity<>(Trans, HttpStatus.CREATED);
    	}catch(Exception e) {
    		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    	
    }
    @PostMapping("/addCustomer")
    public ResponseEntity<Customer> insertCustomer(@RequestBody Customer cus) {
        try {
            bankingServices.addCustomer(cus);
            return new ResponseEntity<>(cus, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateCustomer")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer cus) {
        try {
            bankingServices.addCustomer(cus);
            return new ResponseEntity<>(cus, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/updateCustomer/{aadhar}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("aadhar") String aadhar, @RequestBody Customer updatedCustomer) {
        try {
            Customer existingCustomer = bankingServices.getCustomerByAadhar(aadhar);
            if (existingCustomer != null) {
                existingCustomer.setName(updatedCustomer.getName());
                existingCustomer.setEmail(updatedCustomer.getEmail());
                existingCustomer.setBalance(updatedCustomer.getBalance());

                bankingServices.addCustomer(existingCustomer);
                
                return new ResponseEntity<>(existingCustomer, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateCustomerTransaction/{aadhar}/deposit/{amount}")
    public ResponseEntity<Customer> updateEmployeeBalanceDeposit(@PathVariable("aadhar") String aadhar, @PathVariable("amount") float amount, @RequestBody Transactions th) {
        try {
            Customer existingCustomer = bankingServices.getCustomerByAadhar(aadhar);
            Customer updatedCustomer = bankingServices.depositMoney(existingCustomer, amount);
            th.setTransaction_type("deposit");
            th.setCus(existingCustomer);
            th.setAmount(amount);

            Tservice.addTransactions(th);
            return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateCustomerTransaction/{aadhar}/withdraw/{amount}")
    public ResponseEntity<Customer> updateEmployeeBalanceWithdraw(@PathVariable("aadhar") String aadhar,@PathVariable("amount") float amount,@RequestBody Transactions th) {
        try {
        	  Customer existingCustomer = bankingServices.getCustomerByAadhar(aadhar);
              Customer updatedCustomer = bankingServices.withdrawMoney(existingCustomer, amount);
              th.setTransaction_type("withdraw");
              th.setCus(existingCustomer);
              th.setAmount(amount);

              Tservice.addTransactions(th);
            return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DeleteMapping("/deleteCustomer/{aadhar}")
    public ResponseEntity<HttpStatus> deleteCustomerAadhar(@PathVariable("aadhar") String aadhar) {
        try {
            bankingServices.deleteCustomerByAadhar(aadhar);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
		return null;
    }
}