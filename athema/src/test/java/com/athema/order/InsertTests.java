package com.athema.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.athema.dto.OrderDTO;
import com.athema.service.OrderService;

@SpringBootTest
class InsertTests {

	@Autowired
	OrderService service;
	
	@Test
	void contextLoads() {
		OrderDTO order = new OrderDTO(4, 1, 0, null,1,"홍길동","010-1111-4444","hong4@gmail.com");
		try {
			service.register(order);
			System.out.println("ok");
		} catch (Exception e) {
			System.out.println("fail");
//			e.printStackTrace();
		}
	}

}
