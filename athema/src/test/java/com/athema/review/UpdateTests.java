package com.athema.review;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.athema.dto.ReviewDTO;
import com.athema.service.ReviewService;


@SpringBootTest
class UpdateTests {

	@Autowired
	ReviewService service;

	@Test
	void contextLoads() {
		ReviewDTO review = new ReviewDTO();
			review.setReview_code(2);
			review.setMem_code(2);
			review.setItem_code(4);
			review.setTitle("가족여행");
			review.setContent("에버랜드 와하하하하");
			review.setScore((float)4.5);
			review.setReview_date(null);
			review.setReview_img("rphoto2.jpg");
		try {
			service.modify(review);
			System.out.println(review);
			System.out.println("[ OK ]");
		} catch (Exception e) {
			System.out.println("[ FAIL ]");
			e.printStackTrace();
		}

	}

}
