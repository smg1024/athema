package com.athema.review;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.athema.dto.ReviewDTO;
import com.athema.service.ReviewService;


@SpringBootTest
class SelectTests {

	@Autowired
	ReviewService service;

	@Test
	void contextLoads() {
		ReviewDTO reviewdto = null;

		try {
			reviewdto = service.get(3);
			System.out.println(reviewdto);
			System.out.println("[ OK ]");
		} catch (Exception e) {
			System.out.println("[ FAIL ]");
			e.printStackTrace();
		}

	}

}
