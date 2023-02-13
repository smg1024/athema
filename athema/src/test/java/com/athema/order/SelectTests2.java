package com.athema.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.athema.dto.OrderDTO;
import com.athema.service.OrderService;

@SpringBootTest
class SelectTests2 {

	@Autowired
	OrderService service;
	
	@Test
	void contextLoads() {
		OrderDTO obj = null;
		try {
			obj=service.onum(3);
			System.out.println(obj);
			System.out.println("ok");
		} catch (Exception e) {
			System.out.println("fail");
//			e.printStackTrace();
		}
	}

}
