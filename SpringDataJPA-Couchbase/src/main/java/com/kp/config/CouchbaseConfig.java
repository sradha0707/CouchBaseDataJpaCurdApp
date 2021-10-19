package com.kp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;

@Configuration
public class CouchbaseConfig extends AbstractCouchbaseConfiguration{

	@Override
	public String getConnectionString() {
		return "127.0.0.1";
	}

	@Override
	public String getUserName() {
		return "Sradha";
	}

	@Override
	public String getPassword() {
		return "sradha@kp";
	}

	@Override
	public String getBucketName() {
		return "Customer";
	}

}
