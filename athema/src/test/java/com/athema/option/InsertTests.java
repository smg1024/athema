package com.athema.option;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.athema.dto.OptionDTO;
import com.athema.service.OptionService;

@SpringBootTest
class InsertTests {
	
	@Autowired
	OptionService service;
	
	@Test
	void contextLoads() {
		OptionDTO opt = new OptionDTO();
		opt.setOpt_code(0);
		opt.setItem_code(1);
		opt.setOpt_name("가격");
		opt.setItem_price(42000);
		
		try {
			service.register(opt);
			System.out.println("OK");
		}
		catch(Exception e){
			System.out.println("Failed");
			e.printStackTrace();
		}
	}
}
