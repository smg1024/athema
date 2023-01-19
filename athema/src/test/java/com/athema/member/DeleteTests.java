package com.athema.member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.athema.service.MemberService;

@SpringBootTest
class DeleteTests {
	
	@Autowired
	MemberService service;
	
	@Test
	void contextLoads() {
		try {
			service.remove(2);
			System.out.println("회원 탈퇴");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("회원 탈퇴 실패");
		}
		
		
	}

}
