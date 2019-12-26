package com.fervour.datasource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fervour.datasource.entity.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
}
