package com.javaforweb.dao;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionTestDBLinkDaoImpl implements TransactionTestDBLinkDao {

	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;

	@Override
	public void insertTest(String id) {
		sqlMapClientTemplate.insert("transactionTest.test-from-local-to-dblink-insert", id);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void insertTest(String id, String name) {
		HashMap params = new HashMap<String, String>();
		params.put("id", id);
		params.put("name", name);
		sqlMapClientTemplate.insert("transactionTest.test-dblink-insert", params);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void insertTest2(String key, String value) {
		HashMap params = new HashMap<String, String>();
		params.put("key", key);
		params.put("value", value);
		sqlMapClientTemplate.insert("transactionTest.test2-dblink-insert", params);
	}

	@Override
	public void deleteTest(String id) {
		sqlMapClientTemplate.delete("transactionTest.test-dblink-delete", id);
	}

	@Override
	public void deleteTest2(String key) {
		sqlMapClientTemplate.delete("transactionTest.test2-dblink-delete", key);
	}

}
