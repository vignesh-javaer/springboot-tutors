package com.fervour.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fervour.datasource.service.CustomerService;

@SpringBootApplication
public class DatasourceCoreTestApplication implements CommandLineRunner {
	
	
	@Autowired CustomerService servCust;

	public static void main(String[] args) {
		SpringApplication.run(DatasourceCoreTestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//servCust.getCustomers();
		servCust.getCustomerCriteria();
		
	}

}
