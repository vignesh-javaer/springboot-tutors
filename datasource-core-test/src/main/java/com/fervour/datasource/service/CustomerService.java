package com.fervour.datasource.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fervour.datasource.dao.CustomerRepository;
import com.fervour.datasource.dao.CutomerUpdateDao;
import com.fervour.datasource.entity.Customer;


@Component
public class CustomerService {
	
	@Autowired CustomerRepository custRepo;
	
	@Autowired CutomerUpdateDao custDao;
	
	public void getCustomers() {
		List<Customer> fetchAllCustomer = custRepo.findAll();
		System.out.println(fetchAllCustomer);
	}
	
	
	public void getCustomerCriteria() {
		System.out.println("Execting criteria");
		List<Customer> findAllCustomer = custDao.findAllCustomer();
		findAllCustomer.stream().forEach(c -> System.out.println(c.toString()));
	}

}
