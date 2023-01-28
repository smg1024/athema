package com.athema.item;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.athema.dto.ItemDTO;
import com.athema.service.ItemService;

@SpringBootTest
public class DaySelect {
	@Autowired
	ItemService service;

	@Test
	void contextLoads() {
		ItemDTO itemdto = null;

		try {
			itemdto = service.dayselect(1);
			System.out.println(itemdto);
			System.out.println("날짜 불러오기 성공");
		} catch (Exception e) {
			System.out.println("날짜 불러오기 실패");
			e.printStackTrace();
		}

	}
}
