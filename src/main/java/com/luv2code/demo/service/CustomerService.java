package com.luv2code.demo.service;

import java.util.List;

import com.luv2code.demo.entity.Customer;

public interface CustomerService {

    public List<Customer> findAll();
	
	public Customer findById(int theId);
	
	public void save(Customer theCustomer);
	
	public void deleteById(int theId);
	
}
