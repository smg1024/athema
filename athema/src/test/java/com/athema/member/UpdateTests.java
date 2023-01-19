package com.athema.member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.athema.dto.MemberDTO;
import com.athema.service.MemberService;

@SpringBootTest
class UpdateTests {
	
	@Autowired
	MemberService service;
	
	@Test
	void contextLoads() {
		MemberDTO member = new MemberDTO();
		member.setMem_code(2);
		member.setMem_hp("010-1478-9632");
		member.setMem_birth("20000518");
		member.setMem_nick("어피치");
		member.setMem_pwd("pass0987");
		try {
			service.modify(member);
			System.out.println("레코드 변경 완료");
		} catch (Exception e) {
			System.out.println("레코드 변경 실패");
			e.printStackTrace();
		}
	}

}
