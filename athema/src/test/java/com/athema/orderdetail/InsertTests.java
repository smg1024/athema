package com.athema.orderdetail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.athema.dto.OrdDetailDTO;
import com.athema.service.OrdDetailService;

@SpringBootTest
class InsertTests {

	@Autowired
	OrdDetailService service;
	
	@Test
	void contextLoads() {
		OrdDetailDTO ord = new OrdDetailDTO(7, 4, 10, 2, 2, 0, null);
		try {
			service.register(ord);
			System.out.println("ok");
		} catch (Exception e) {
			System.out.println("fail");
//			e.printStackTrace();
		}
	}

}
