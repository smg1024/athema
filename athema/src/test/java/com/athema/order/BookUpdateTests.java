package com.athema.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.athema.dto.OrderDTO;
import com.athema.service.OrderService;

@SpringBootTest
class BookUpdateTests {

	@Autowired
	OrderService service;
	
	@Test
	void contextLoads() {
		OrderDTO order = new OrderDTO(3, "가가", "010-5555-5555", "gaga@gmail.com");
		try {
			service.modify(order);
			System.out.println("ok");
		} catch (Exception e) {
			System.out.println("fail");
			//e.printStackTrace();
		}
	}

}
