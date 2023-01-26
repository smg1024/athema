package com.athema.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.athema.service.OrderService;

@SpringBootTest
class DeleteTests {

	@Autowired
	OrderService service;
	
	@Test
	void contextLoads() {
		try {
			service.remove(4);
			System.out.println("ok");
		} catch (Exception e) {
			System.out.println("fail");
			//e.printStackTrace();
		}
	}

}
