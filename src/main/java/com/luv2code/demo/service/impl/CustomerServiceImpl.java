package com.luv2code.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.demo.entity.Customer;
import com.luv2code.demo.exc.CustomerNotFoundException;
import com.luv2code.demo.repo.CustomerRepository;
import com.luv2code.demo.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public Customer findById(int theId) {
		Optional<Customer> result = customerRepository.findById(theId);

		if (result.isEmpty()) {
			// we didn't find the Customer
			throw new CustomerNotFoundException("Did not find Customer id - " + theId);
		}

		return result.get();
	}

	@Override
	public void save(Customer theCustomer) {
		customerRepository.save(theCustomer);
	}

	@Override
	public void deleteById(int theId) {

		Optional<Customer> result = customerRepository.findById(theId);

		if (result.isEmpty()) {
			// we didn't find the Customer
			throw new CustomerNotFoundException("Did not find Customer id - " + theId);
		}

		customerRepository.deleteById(theId);
	}

	@Override
	public Customer updateCustomer(int theId, Long salary) {

		Optional<Customer> result = customerRepository.findById(theId);

		if (result.isEmpty()) {
			// we didn't find the Customer
			throw new CustomerNotFoundException("Did not find Customer id - " + theId);
		}

		result.get().setSalary(salary);

		return customerRepository.save(result.get());
	}

}
