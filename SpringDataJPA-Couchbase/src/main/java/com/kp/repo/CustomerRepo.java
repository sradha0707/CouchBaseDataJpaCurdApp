package com.kp.repo;

import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import com.kp.model.Customer;

@Repository
public interface CustomerRepo extends CouchbaseRepository<Customer, String> {

	public Customer findByName(String name);
	public Customer deleteByEmail(String email);
}
