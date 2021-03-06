package com.example.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.modal.Customer;
import com.example.springboot.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	public List<Customer> getAllCustomers(){
		return customerRepository.findAll();
	}

	public void createCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	public boolean deleteCustomer(long id) {
		boolean isFailed = false;
		try {
			customerRepository.deleteById(id);
		}catch (Exception e) {
			isFailed = true;
			// e.printStackTrace();
		}
		return isFailed;
	}
}
