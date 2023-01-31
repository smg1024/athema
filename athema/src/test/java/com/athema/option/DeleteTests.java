package com.athema.option;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.athema.service.OptionService;

@SpringBootTest
class DeleteTests {
	
	@Autowired
	OptionService service;
	
	@Test
	void contextLoads() {
		try {
			service.remove(3);
			System.out.println("등록된 상품 옵션 삭제 성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("등록된 상품 옵션 삭제 실패");
		}
		
	}

}
