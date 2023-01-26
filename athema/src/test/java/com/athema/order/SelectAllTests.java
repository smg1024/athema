package com.athema.order;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.athema.dto.OrderDTO;
import com.athema.service.OrderService;

@SpringBootTest
class SelectAllTests {

	@Autowired
	OrderService service;
	
	@Test
	void contextLoads() {
		List<OrderDTO> objs = null;
		try {
			objs = service.getall();
			for(OrderDTO obj:objs) {
				System.out.println(obj);
			}
			System.out.println("ok");
		} catch (Exception e) {
			System.out.println("fail");
			//e.printStackTrace();
		}
	}

}
