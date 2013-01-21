package com.javaforweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionTestServiceImpl implements
		TransactionTestService {

	@Autowired
	private TransactionTestLocalService testLocalService;
	
	@Autowired
	private TransactionTestDBLinkService testDBLinkService;
	
	@Override
	public void insertTest(String id, String name) {
		testLocalService.insertTest(id, name);
		testDBLinkService.insertTest(id);
	}

	@Override
	public void insertTest2(String key, String value) {
		testDBLinkService.insertTest2(key, value);
		testLocalService.insertTest2(key);
	}

	@Override
	public void deleteAll(String pk) {
		testDBLinkService.deleteTest(pk);
		testLocalService.deleteTest(pk);
		testDBLinkService.deleteTest2(pk);
		testLocalService.deleteTest2(pk);
	}


}
