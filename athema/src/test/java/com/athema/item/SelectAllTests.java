package com.athema.item;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.athema.dto.ItemDTO;
import com.athema.service.ItemService;


@SpringBootTest
class SelectAllTests {

	@Autowired
	ItemService service;

	@Test
	void contextLoads() {
		List<ItemDTO> items = null;

		try {

			items = service.getall();
			for (ItemDTO r : items) {
				System.out.println(r);
			}
			System.out.println("여행상품 목록 불러오기 성공");
		} catch (Exception e) {
			System.out.println("여행상품 목록 불러오기 실패");
			e.printStackTrace();
		}

	}

}
