package com.athema.orderdetail;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.athema.dto.OrdDetailDTO;
import com.athema.service.OrdDetailService;

@SpringBootTest
class SelectAllTests {

	@Autowired
	OrdDetailService service;
	
	@Test
	void contextLoads() {
		List<OrdDetailDTO> objs = null;
		try {
			objs = service.getall();
			for(OrdDetailDTO obj:objs) {
				System.out.println(obj);
			}
			System.out.println("ok");
		} catch (Exception e) {
			System.out.println("fail");
			//e.printStackTrace();
		}
	}

}
