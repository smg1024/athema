package com.athema.review;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.athema.dto.ReviewDTO;
import com.athema.service.ReviewService;


@SpringBootTest
class SelectAllTests {

	@Autowired
	ReviewService service;

	@Test
	void contextLoads() {
		List<ReviewDTO> reviews = null;

		try {

			reviews = service.getall();
			for (ReviewDTO r : reviews) {
				System.out.println(r);
			}
			System.out.println("[ OK ]");
		} catch (Exception e) {
			System.out.println("[ FAIL ]");
			e.printStackTrace();
		}

	}

}
