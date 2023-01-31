package com.athema.item;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.athema.dto.ItemDTO;
import com.athema.service.ItemService;


@SpringBootTest
class SearchLocTests {

	@Autowired
	ItemService service;

	@Test
	void contextLoads() {
		List<String> loc_names = new ArrayList<String>();
		List<ItemDTO> list = new ArrayList<ItemDTO>();
		
		loc_names.add("경기");
		loc_names.add("인천");
		
		System.out.println(loc_names);
		
		try {
			for(String cate_name : loc_names) {
				List<ItemDTO> temp = null;
				temp = service.search_loc(cate_name);
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
