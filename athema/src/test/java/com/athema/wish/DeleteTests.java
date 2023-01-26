package com.athema.wish;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.athema.service.WishService;

@SpringBootTest
class DeleteTests {
	
	@Autowired
	WishService service;
	
	@Test
	void contextLoads() {
		try {
			service.remove(1);
			System.out.println("좋아요한 상품 삭제 성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("좋아요한 상품 삭제 실패");
		}
		
	}

}