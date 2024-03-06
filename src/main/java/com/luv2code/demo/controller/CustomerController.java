package com.luv2code.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.demo.entity.Customer;
import com.luv2code.demo.exc.CustomerNotFoundException;
import com.luv2code.demo.service.CustomerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	
	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		
		List<Customer> theCustomers = customerService.findAll();
		
		if(theCustomers.isEmpty()) {
			throw new CustomerNotFoundException("There's No Customers - 🥲");
		}
		
		return theCustomers;
	}
	
	@GetMapping("/customers/{customer_id}")
	public Customer getCustomer(@PathVariable("customer_id") int customer_id) {
        
		Customer theCustomer = customerService.findById(customer_id);
		
		if(theCustomer == null) {
			throw new CustomerNotFoundException("Customer id not found - " + customer_id);
		}
		
		return theCustomer;
	}
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer theCustomer) {
		
		theCustomer.setId(0);
		
		customerService.save(theCustomer);
		
		return theCustomer;
	}
	
	@DeleteMapping("/customers/{customer_id}")
	public String deleteCustomer(@PathVariable("customer_id") int customer_id) {
		
		Customer theCustomer = customerService.findById(customer_id);
		
		if(theCustomer == null) {
			throw new CustomerNotFoundException("Customer id not found - " + customer_id);
		}
		
		customerService.deleteById(customer_id);
		
		return "Deleted Customer Id - " + customer_id;
	}
	
}
