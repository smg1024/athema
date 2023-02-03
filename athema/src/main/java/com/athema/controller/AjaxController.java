package com.athema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.athema.service.MemberService;
import com.athema.service.OptionService;

@RestController
public class AjaxController {
	
	@Autowired
	MemberService mservice;
	
	@Autowired
	OptionService oservice;
	
	// 이메일 중복체크
	@RequestMapping("/checkemail")
	public int checkemail(String email) {
		int result = 0;
		try {
			// 이메일 조회되면 cnt값이 result에 반영됨
			result = mservice.getemail(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping("/getprice")
	public int getprice(int item_code, int opt_code, int opt_quantity) {
		int price = 0;
		
		try {
			price = oservice.getprice(item_code, opt_code, opt_quantity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return price;
	}

}
