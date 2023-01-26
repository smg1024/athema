package com.athema.option;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.athema.dto.OptionDTO;
import com.athema.service.OptionService;

@SpringBootTest
class SelectTests {
	
	@Autowired
	OptionService service;
	
	@Test
	void contextLoads() {
		OptionDTO opt = null;
		try {
			opt = service.get(1);
			System.out.println(opt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
