package com.sapient.BankApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//
//@EnableEurekaClient
@SpringBootApplication
@Component
public class BankAppApplication {
 
	public static void main(String[] args) {
		SpringApplication.run(BankAppApplication.class, args);
	}

}
  