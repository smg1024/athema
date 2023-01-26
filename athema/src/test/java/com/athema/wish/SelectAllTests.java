package com.athema.wish;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.athema.dto.WishDTO;
import com.athema.service.WishService;


@SpringBootTest
class SelectAllTests {

	@Autowired
	WishService service;

	@Test
	void contextLoads() {
		List<WishDTO> wishs = null;

		try {

			wishs = service.getall();
			for (WishDTO r : wishs) {
				System.out.println(r);
			}
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("Failed");
			e.printStackTrace();
		}

	}

}