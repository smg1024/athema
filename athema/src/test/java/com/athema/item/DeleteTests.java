package com.athema.item;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.athema.service.ItemService;



@SpringBootTest
class DeleteTests {

	@Autowired
	ItemService service;

	@Test
	void contextLoads() {
		try {
			service.remove(1);
			System.out.println("여행상품 삭제 성공");
		} catch (Exception e) {
			System.out.println("여행상품 삭제 실패");
			e.printStackTrace();
		}

	}

}
