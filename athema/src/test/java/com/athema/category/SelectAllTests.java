package com.athema.category;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.athema.dto.CategoryDTO;
import com.athema.service.CategoryService;


@SpringBootTest
class SelectAllTests {

	@Autowired
	CategoryService service;

	@Test
	void contextLoads() {
		List<CategoryDTO> cates = null;

		try {
			cates = service.getall();
			for (CategoryDTO r : cates) {
				System.out.println(r);
			}
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("Failed");
			e.printStackTrace();
		}

	}

}