package com.athema.category;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.athema.service.CategoryService;

@SpringBootTest
class DeleteTests {
	
	@Autowired
	CategoryService service;
	
	@Test
	void contextLoads() {
		try {
			service.remove(71);
			System.out.println("등록된 카테고리 삭제 성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("등록된 카테고리 삭제 실패");
		}
		
	}

}
