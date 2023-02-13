package com.athema.item;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.athema.dto.ItemDTO;
import com.athema.service.ItemService;


@SpringBootTest
class InsertTests {

	@Autowired
	ItemService service;

	@Test
	void contextLoads() {								
		ItemDTO item = new ItemDTO();
			item.setItem_code(1);
			item.setItem_name("휴애리 자연생활공원");
			item.setItem_loc("제주 서귀포시");
			item.setItem_detail("야외 식물원 같은 곳");
			item.setCate_code(6);
			item.setLat(33.22212);
			item.setLng(123.14141);
			item.setExp_days(14);
			try {
			service.register(item);
			System.out.println("여행상품 등록 성공");
		} catch (Exception e) {
			System.out.println("여행상품 등록 실패");
			e.printStackTrace();
		}

	}

}
