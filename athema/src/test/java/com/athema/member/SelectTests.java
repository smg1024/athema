package com.athema.member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.athema.dto.MemberDTO;
import com.athema.service.MemberService;

@SpringBootTest
class SelectTests {
	
	@Autowired
	MemberService service;
	
	@Test
	void contextLoads() {
		MemberDTO member = null;
		try {
			member = service.get(1);
			System.out.println(member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
