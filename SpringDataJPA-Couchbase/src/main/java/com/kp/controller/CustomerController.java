package com.kp.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kp.model.Customer;
import com.kp.repo.CustomerRepo;
import com.kp.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerRepo repository;
	
	@Autowired
	CustomerService service;
	
	public static final Logger logger = Logger.getLogger(CustomerController.class.getName());
	
	@PostMapping(value="/save", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> saveCustomerData(@RequestBody Customer customer){
		logger.info(""+customer);
		repository.save(customer);
		String msg = "Record Inserted Successfully";
		return new ResponseEntity<>(msg,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/findAll")
	 public ResponseEntity<List<Customer>> getAllCustomerData(){
		List<Customer> findAllCustomer = repository.findAll();
		
		return new ResponseEntity<>(findAllCustomer,HttpStatus.OK);
	}
	
	@GetMapping("/findbyid/{cid}")
	public ResponseEntity<String> getCustomerById(@PathVariable("cid") String id){
		Object customerById = repository.findById(id);
		logger.info(""+ customerById);
		return new ResponseEntity<>("Record Found ",HttpStatus.OK);
	}
	
	@PutMapping(value="/update/{id}", consumes= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> updateCustomerById(@RequestBody Customer customer, @PathVariable("id") String id){	
		service.updateCustomerRecord(customer,id);
		return new ResponseEntity<>("Updatedc Record Successfully",HttpStatus.OK);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable String id){
		repository.deleteById(id);
		return new ResponseEntity<>("Record Deleted Successfully",HttpStatus.OK);
	}
	
	@GetMapping(value="/findbyname/{name}")
	public ResponseEntity<String> findByName(@PathVariable String name){
		Customer customerByName = repository.findByName(name);
		logger.info(" "+ customerByName);
		return new ResponseEntity<>("Record Found by customer name",HttpStatus.OK);
	  
	}
	
	
	
	

}
