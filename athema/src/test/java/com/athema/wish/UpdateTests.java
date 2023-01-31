package com.athema.wish;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.athema.dto.WishDTO;
import com.athema.service.WishService;


@SpringBootTest
class UpdateTests {

	@Autowired
	WishService service;

	@Test
	void contextLoads() {
		WishDTO wish = new WishDTO(5, 3);

		try {
			service.modify(wish);
			System.out.println("좋아요한 상품 수정 성공");
		} catch (Exception e) {
			System.out.println("좋아요한 상품 수정 실패");
			e.printStackTrace();
		}

	}

}
