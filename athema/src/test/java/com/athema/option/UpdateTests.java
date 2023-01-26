package com.athema.option;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.athema.dto.OptionDTO;
import com.athema.service.OptionService;

@SpringBootTest
class UpdateTests {
	
	@Autowired
	OptionService service;

	@Test
	void contextLoads() {
		OptionDTO optup = new OptionDTO();

		try {
			service.modify(optup);
			System.out.println("상품 옵션 수정 성공");
		} catch (Exception e) {
			System.out.println("상품 옵션 수정 실패");
			e.printStackTrace();
		}

	}
}
