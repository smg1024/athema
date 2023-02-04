package com.athema.review;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.athema.dto.ReviewDTO;
import com.athema.service.ReviewService;


@SpringBootTest
class InsertTests {

	@Autowired
	ReviewService service;

	@Test
	void contextLoads() {								
		ReviewDTO review = new ReviewDTO(4, 1, 1, "aa", "a", 1, null, null);
		try {
			service.register(review);
			System.out.println("[OK]");
		} catch (Exception e) {
			System.out.println("[ FAIL ]");
			e.printStackTrace();
		}

	}

}
