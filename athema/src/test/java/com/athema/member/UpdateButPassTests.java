package com.athema.member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.athema.dto.MemberDTO;
import com.athema.service.MemberService;

@SpringBootTest
class UpdateButPassTests {
	
	@Autowired
	MemberService service;
	
	@Test
	void contextLoads() {
		MemberDTO member = new MemberDTO();
		member.setMem_code(2);
		member.setMem_hp("010-2580-9632");
		member.setMem_birth("20050518");
		member.setMem_nick("마블리");
		try {
			service.modifybutpass(member);
			System.out.println("SNS 레코드 변경 완료");
		} catch (Exception e) {
			System.out.println("SNS 레코드 변경 실패");
			e.printStackTrace();
		}
	}

}
