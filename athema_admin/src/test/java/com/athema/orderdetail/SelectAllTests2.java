package com.athema.orderdetail;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.athema.dto.OrdDetailDTO;
import com.athema.service.OrdDetailService;

@SpringBootTest
class SelectAllTests2 {

	@Autowired
	OrdDetailService service;
	
	@Test
	void contextLoads() {
		List<OrdDetailDTO> objs = null;

		try {
			objs = service.ordall(59);
			System.out.println(objs);
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
