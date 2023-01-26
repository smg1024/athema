package com.athema.category;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.athema.dto.CategoryDTO;
import com.athema.service.CategoryService;

@SpringBootTest
class UpdateTests {
	
	@Autowired
	CategoryService service;

	@Test
	void contextLoads() {
		CategoryDTO cateup = new CategoryDTO();

		try {
			service.modify(cateup);
			System.out.println("카테고리 수정 성공");
		} catch (Exception e) {
			System.out.println("카테고리 수정 실패");
			e.printStackTrace();
		}
	}
}
