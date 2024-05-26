package com.luv2code.demo.service;

import java.util.List;

import com.luv2code.demo.entity.Customer;

public interface CustomerService {

	List<Customer> findAll();

	Customer findById(int theId);

	void save(Customer theCustomer);

	void deleteById(int theId);

	Customer updateCustomer(int theId, Long salary);

}
