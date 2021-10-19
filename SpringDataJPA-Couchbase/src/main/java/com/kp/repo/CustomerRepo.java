package com.kp.repo;

import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import com.kp.model.Customer;

@Repository
public interface CustomerRepo extends CouchbaseRepository<Customer, Integer> {

}
