package com.athema.item;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.athema.dto.ItemDTO;
import com.athema.service.ItemService;


@SpringBootTest
class SearchThemeTests {

	@Autowired
	ItemService service;

	@Test
	void contextLoads() {
		List<Integer> theme_codes = new ArrayList<Integer>();
		List<ItemDTO> list = new ArrayList<ItemDTO>();
		
		theme_codes.add(3);
		theme_codes.add(5);
		
		System.out.println(theme_codes);
		
		try {
			for(int up_cate_code : theme_codes) {
				List<ItemDTO> temp = null;
				temp = service.search_theme(up_cate_code);
				for(ItemDTO item : temp) {
					list.add(item);
				}
			}
			System.out.println(list);
			
			System.out.println("여행상품 불러오기 성공");
		} catch (Exception e) {
			System.out.println("여행상품 불러오기 실패");
			e.printStackTrace();
		}

	}

}
