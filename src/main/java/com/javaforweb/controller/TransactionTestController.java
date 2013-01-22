package com.javaforweb.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaforweb.service.TransactionTestDBLinkService;
import com.javaforweb.service.TransactionTestLocalService;
import com.javaforweb.service.TransactionTestService;

/**
 * DESC : 
 * 
 * @Company ePapyrus.inc
 * @author taewook.jang
 * @Date 2012. 11. 21. 오후 2:06:39
 */
@Controller
public class TransactionTestController {

	@Autowired
	private TransactionTestService testService;
	
	@Autowired
	private TransactionTestDBLinkService testDBLinkService;
	
	@Autowired
	private TransactionTestLocalService testLocalService;
	
	String id = "100";
	String name = "남자다잉";
	
	@RequestMapping(value = "/tr/delAll.do")
	@ResponseBody
	public String deleteAll(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		testService.deleteAll(id);
		return "DB Init Complete!";
	}
	
	@RequestMapping(value = "/tr/test_by_service.do")
	@ResponseBody
	public String transactionTest01() {
		testService.deleteAll(id);
		testDBLinkService.insertTest(id, "두 번째 쿼리에서 오류 발생을 위해");
		testService.insertTest(id, name);
		return "또 다른 Service 에서 해당 Service 에 대한 Transaction Test 완료!";
	}
	
	@RequestMapping(value = "/tr/test_direct.do")
	@ResponseBody
	public String transactionTest02() {
		testService.deleteAll(id);
		testLocalService.insertTest(id, name);
		testDBLinkService.insertTest(id, "두 번째 쿼리에서 오류 발생을 위해");
		testDBLinkService.insertTest(id);
		return "해당 Service 에 대한 직접적 Transaction Test 완료!";
	}
	
	@RequestMapping(value = "/tr/test_direct2.do")
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@ResponseBody
	public String transactionTest03() {
		testService.deleteAll(id);
		testLocalService.insertTest(id, name);
		testDBLinkService.insertTest(id, "두 번째 쿼리에서 오류 발생을 위해");
		testDBLinkService.insertTest(id);
		return "해당 Service 에 대한 직접적 Transaction Test 2 완료!";
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public String handleException(Exception e){
		return "==== result : " + e.getMessage();
	}
}
