package com.javaforweb.service;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface TransactionTestService {
	
	void insertTest(String id, String name);
	
	void insertTest2(String key, String value);

	void deleteAll(String id);
	
}
