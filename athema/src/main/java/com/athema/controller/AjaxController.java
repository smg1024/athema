package com.athema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.athema.service.MemberService;

@RestController
public class AjaxController {
	
	@Autowired
	MemberService mservice;
	
	@RequestMapping("/checkemail")
	public int checkemail(String email) {
		int result = 0;
		try {
			result = mservice.getemail(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
