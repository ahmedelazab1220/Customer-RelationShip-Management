package com.luv2code.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.demo.entity.Customer;
import com.luv2code.demo.service.CustomerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("")
	public List<Customer> getAllCustomers() {

		return customerService.findAll();

	}

	@GetMapping("/{customer_id}")
	public Customer getCustomer(@PathVariable("customer_id") int customer_id) {

		return customerService.findById(customer_id);

	}

	@PostMapping("")
	public ResponseEntity<?> addCustomer(@RequestBody Customer theCustomer) {

		customerService.save(theCustomer);

		return ResponseEntity.ok("Customer added successfully");
	}

	@DeleteMapping("/{customer_id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable("customer_id") int customer_id) {

		customerService.deleteById(customer_id);

		return ResponseEntity.ok("Deleted Customer Id - " + customer_id);
	}

	@PutMapping("/{customer_id}")
	public Customer updateCustomer(@PathVariable("customer_id") int customer_id,
			@RequestParam(name = "salary") Long salary) {

		return customerService.updateCustomer(customer_id, salary);

	}

}
