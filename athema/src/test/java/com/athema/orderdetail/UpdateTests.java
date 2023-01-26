package com.athema.orderdetail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.athema.dto.OrdDetailDTO;
import com.athema.service.OrdDetailService;

@SpringBootTest
class UpdateTests {

	@Autowired
	OrdDetailService service;
	
	@Test
	void contextLoads() {
		OrdDetailDTO ord = new OrdDetailDTO(1, 1, 1);
		try {
			service.modify(ord);
			System.out.println("ok");
		} catch (Exception e) {
			System.out.println("fail");
			//e.printStackTrace();
		}
	}

}
