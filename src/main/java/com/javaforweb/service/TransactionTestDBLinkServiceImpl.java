package com.javaforweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaforweb.dao.TransactionTestDBLinkDao;

@Service
public class TransactionTestDBLinkServiceImpl implements
		TransactionTestDBLinkService {
	@Autowired
	private TransactionTestDBLinkDao testDBLinkDao;
	
	@Override
	public void insertTest(String id) {
		testDBLinkDao.insertTest(id);
	}

	@Override
	public void insertTest(String id, String name) {
		testDBLinkDao.insertTest(id, name);
	}

	@Override
	public void insertTest2(String key, String value) {
		testDBLinkDao.insertTest2(key, value);
	}

	@Override
	public void deleteTest(String id) {
		testDBLinkDao.deleteTest(id);
	}

	@Override
	public void deleteTest2(String key) {
		testDBLinkDao.deleteTest2(key);
	}


}
