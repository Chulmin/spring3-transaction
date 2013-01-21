package com.javaforweb.service;


public interface TransactionTestDBLinkService {

	void insertTest(String id);
	
	void insertTest(String id, String name);
	
	void insertTest2(String key, String value);

	void deleteTest(String id);

	void deleteTest2(String key);
	
	
}
