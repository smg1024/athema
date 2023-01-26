package com.athema.wish;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.athema.dto.WishDTO;
import com.athema.service.WishService;

@SpringBootTest
class InsertTests {
	
	@Autowired
	WishService service;
	
	@Test
	void contextLoads() {
		WishDTO wish = new WishDTO();
		wish.setWish_code(0);
		wish.setItem_code(1);
		wish.setMem_code(1);
		
		try {
			service.register(wish);
			System.out.println("OK");
		}
		catch(Exception e){
			System.out.println("Failed");
			e.printStackTrace();
		}
	}
}
