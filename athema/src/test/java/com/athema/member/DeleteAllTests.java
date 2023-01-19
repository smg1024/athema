package com.athema.member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.athema.service.MemberService;

@SpringBootTest
class DeleteAllTests {
	
	@Autowired
	MemberService service;
	
	@Test
	void contextLoads() {
		try {
			service.removeall(2);
			System.out.println("계정 영구 DB 삭제");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("삭제 실패");
		}
		
		
	}

}
