package com.athema.category;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.athema.dto.OptionDTO;
import com.athema.service.OptionService;


@SpringBootTest
class SelectAllTests {

	@Autowired
	OptionService service;

	@Test
	void contextLoads() {
		List<OptionDTO> opts = null;

		try {
			opts = service.getall();
			for (OptionDTO r : opts) {
				System.out.println(r);
			}
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("Failed");
			e.printStackTrace();
		}

	}

}