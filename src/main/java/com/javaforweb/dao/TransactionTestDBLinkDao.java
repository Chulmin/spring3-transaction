package com.javaforweb.dao;

public interface TransactionTestDBLinkDao {

	void insertTest(String id);

	void insertTest(String id, String name);
	
	void insertTest2(String key, String value);

	void deleteTest(String id);

	void deleteTest2(String key);
	


}
