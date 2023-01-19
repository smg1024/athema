package com.athema.member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.athema.dto.MemberDTO;
import com.athema.service.MemberService;

@SpringBootTest
class InsertTests {
	
	@Autowired
	MemberService service;
	
	@Test
	void contextLoads() {
		MemberDTO member = new MemberDTO();
		member.setMem_email("example@athema.com");
		member.setMem_hp("010-1234-5678");
		member.setMem_nick("홍당무");
		member.setMem_name("홍길동");
		member.setMem_pwd("pass1234");
		member.setMem_birth("19880808");
		try {
			service.register(member);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("Fail");
			e.printStackTrace();
		}
	}

}
