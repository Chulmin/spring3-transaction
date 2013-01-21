package com.javaforweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaforweb.dao.TransactionTestLocalDao;

@Service
public class TransactionTestLocalServiceImpl implements
		TransactionTestLocalService {
	
	@Autowired
	private TransactionTestLocalDao testLocalDao;

	@Override
	public void insertTest(String id, String name) {
		testLocalDao.insertTest(id, name);
	}

	@Override
	public void insertTest2(String key) {
		testLocalDao.insertTest2(key);
	}

	@Override
	public void deleteTest(String id) {
		testLocalDao.deleteTest(id);
	}

	@Override
	public void deleteTest2(String key) {
		testLocalDao.deleteTest2(key);
	}
	
	
	

}



