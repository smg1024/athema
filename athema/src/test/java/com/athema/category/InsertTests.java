package com.athema.category;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.athema.dto.CategoryDTO;
import com.athema.service.CategoryService;

@SpringBootTest
class InsertTests {
	
	@Autowired
	CategoryService service;
	
	@Test
	void contextLoads() {
		CategoryDTO cate = new CategoryDTO();
		cate.setCate_code(0);
		cate.setCate_name("테마파크");
		cate.setUp_cate_code(1);
		
		try {
			service.register(cate);
			System.out.println("OK");
		}
		catch(Exception e){
			System.out.println("Failed");
			e.printStackTrace();
		}
	}
}
