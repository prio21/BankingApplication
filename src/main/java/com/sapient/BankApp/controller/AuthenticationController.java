package com.sapient.BankApp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.BankApp.Services.BankingServices;
import com.sapient.BankApp.model.Customer;

import lombok.RequiredArgsConstructor;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
	
	 Customer loginCus = null;
	
	
	private final AuthenticationService service;
	private final BankingServices bankingServices;
	
	@PostMapping("/register") 
	  public ResponseEntity<AuthenticationResponse> register(
	      @RequestBody RegisterRequest request
	  ) {

		Customer cus = bankingServices.getCustomerByEmail(request.getEmail());
		loginCus = cus;
	    return ResponseEntity.ok(service.register(request));
	  }
	
	@PostMapping("/authenticate")
	  public ResponseEntity<AuthenticationResponse> authenticate(
	      @RequestBody AuthenticationRequest request
	  ) {
		Customer cus = bankingServices.getCustomerByEmail(request.getEmail());
		loginCus = cus;
		
	    return ResponseEntity.ok(service.authenticate(request));
	  }

	
}
