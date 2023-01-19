package com.athema.member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.athema.service.MemberService;

@SpringBootTest
class SelectEmailTests {
	
	@Autowired
	MemberService service;
	
	@Test
	void contextLoads() {
		int member = 0;
		try {
			member = service.getemail("example@athema.com");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(member);
		
		
	}

}
