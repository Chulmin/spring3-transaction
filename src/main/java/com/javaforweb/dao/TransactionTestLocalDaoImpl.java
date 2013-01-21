package com.javaforweb.dao;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionTestLocalDaoImpl implements TransactionTestLocalDao {

	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void insertTest(String id, String name) {
		HashMap params = new HashMap<String, String>();
		params.put("id", id);
		params.put("name", name);
		sqlMapClientTemplate.insert("transactionTest.test-local-insert", params);
	}

	@Override
	public void insertTest2(String key) {
		sqlMapClientTemplate.insert("transactionTest.test2-from-dblink-to-local-insert", key);
	}
	
	@Override
	public void deleteTest(String id) {
		sqlMapClientTemplate.delete("transactionTest.test-local-delete", id);
	}

	@Override
	public void deleteTest2(String key) {
		sqlMapClientTemplate.delete("transactionTest.test2-local-delete", key);
	}
	
	
}