package com.kp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kp.model.Customer;
import com.kp.repo.CustomerRepo;

@Service
public class CustomerService {

	 @Autowired
		CustomerRepo repository;
	    
		public void updateCustomerRecord(Customer customer, String id) {
			List<Customer> listOfCustomer = repository.findAll();
			for(int i =0; i< listOfCustomer.size(); i++) {
				Customer cust =  listOfCustomer.get(i);
				if(cust.getId().equals(id)) {
					cust.setId(id);
					cust.setName(customer.getName());
					cust.setEmail(customer.getEmail());
					repository.save(cust);
					return;
				}
			}
			
		}
		
}
