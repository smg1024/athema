package com.athema.review;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.athema.service.ReviewService;



@SpringBootTest
class DeleteTests {

	@Autowired
	ReviewService service;

	@Test
	void contextLoads() {
		try {
			service.remove(11);
			System.out.println("[ OK ]");
		} catch (Exception e) {
			System.out.println("[ FAIL ]");
			e.printStackTrace();
		}

	}

}
