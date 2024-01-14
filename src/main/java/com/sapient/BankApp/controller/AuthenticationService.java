package com.sapient.BankApp.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.sapient.BankApp.Repository.CustomerRepository;
import com.sapient.BankApp.config.JwtService;
import com.sapient.BankApp.model.Customer;
import com.sapient.BankApp.model.Role;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

	private final CustomerRepository repository;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	 private final AuthenticationManager authenticationManager;
	
	public AuthenticationResponse register(RegisterRequest request) {
	  
		 Customer user = Customer.builder()
				 	.aadhar(request.getAadhar())
			        .email(request.getEmail())
			        .name(request.getName())
			        .balance(request.getBalance())
			        .password(passwordEncoder.encode(request.getPassword()))
			        .role(Role.CUSTOMER)
			        .build();
		repository.save(user);
		
		var jwtToken = jwtService.generateToken(user);
		 return AuthenticationResponse.builder()
		        .token(jwtToken)
		        .build();
	  }
	
	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		
		authenticationManager.authenticate(
				  new UsernamePasswordAuthenticationToken(
				            request.getEmail(),
				            request.getPassword()
				)
				  );
		
		 Customer user = repository.findByEmail(request.getEmail())
			        .orElseThrow();
		 var jwtToken = jwtService.generateToken(user);
		 return AuthenticationResponse.builder()
		        .token(jwtToken)
		        .build();
		
		
	}
}
