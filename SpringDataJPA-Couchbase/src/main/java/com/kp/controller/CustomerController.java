package com.kp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kp.model.Customer;
import com.kp.repo.CustomerRepo;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerRepo customerRepo ;
	
	@PostMapping(value="/save", consumes= {"application/json"})
	@ResponseStatus(HttpStatus.CREATED)
	public String saveCustomer(@RequestBody  Customer customer) {
		customerRepo.save(customer);
		return "Customer Saved successfully";
	}
	
	@GetMapping("/getAll")
	@ResponseStatus(HttpStatus.OK)
	public List<Customer> getAllCustomer(){
		return customerRepo.findAll();
	}

}
