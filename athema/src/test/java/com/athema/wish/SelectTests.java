package com.athema.wish;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.athema.dto.WishDTO;
import com.athema.service.WishService;

@SpringBootTest
class SelectTests {
	
	@Autowired
	WishService service;
	
	@Test
	void contextLoads() {
		WishDTO wish = null;
		try {
			wish = service.get(1);
			System.out.println(wish);
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed");
		}
		
	}

}