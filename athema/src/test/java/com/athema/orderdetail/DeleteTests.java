package com.athema.orderdetail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.athema.service.OrdDetailService;

@SpringBootTest
class DeleteTests {

	@Autowired
	OrdDetailService service;
	
	@Test
	void contextLoads() {
		try {
			service.remove(5);
			System.out.println("ok");
		} catch (Exception e) {
			System.out.println("fail");
			//e.printStackTrace();
		}
	}

}
