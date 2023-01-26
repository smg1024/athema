package com.athema.item;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.athema.dto.ItemDTO;
import com.athema.service.ItemService;


@SpringBootTest
class UpdateTests {

	@Autowired
	ItemService service;

	@Test
	void contextLoads() {
		ItemDTO itemdto = new ItemDTO();

		try {
			service.modify(itemdto);
			System.out.println("여행상품 수정 성공");
		} catch (Exception e) {
			System.out.println("여행상품 수정 실패");
			e.printStackTrace();
		}

	}

}
