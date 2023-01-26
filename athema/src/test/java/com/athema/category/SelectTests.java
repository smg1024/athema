package com.athema.category;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.athema.dto.CategoryDTO;
import com.athema.service.CategoryService;

@SpringBootTest
class SelectTests {
	
	@Autowired
	CategoryService service;
	
	@Test
	void contextLoads() {
		CategoryDTO cate = null;
		try {
			cate = service.get(1);
			System.out.println(cate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
