package com.athema.orderdetail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.athema.dto.OrdDetailDTO;
import com.athema.service.OrdDetailService;

@SpringBootTest
class SelectTests {

	@Autowired
	OrdDetailService service;
	
	@Test
	void contextLoads() {
		OrdDetailDTO obj = null;
		try {
			obj=service.get(1);
			System.out.println(obj);
			System.out.println("ok");
		} catch (Exception e) {
			System.out.println("fail");
			//e.printStackTrace();
		}
	}

}
