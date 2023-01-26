package com.athema.review;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.athema.dto.ReviewDTO;
import com.athema.service.ReviewService;


@SpringBootTest
class Avg_ratingTests {

	@Autowired
	ReviewService service;

	@Test
	void contextLoads() {
		double avg_rating = 0;
		try {
			avg_rating = service.avg_rating(1);
			System.out.println(avg_rating);
			System.out.println("[ OK ]");
		} catch (Exception e) {
			System.out.println("[ FAIL ]");
			e.printStackTrace();
		}

	}

}
