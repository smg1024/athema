package com.athema.orderdetail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.athema.dto.OrdDetailDTO;
import com.athema.service.OrdDetailService;

@SpringBootTest
class InsertTests2 {

	@Autowired
	OrdDetailService service;
	
	@Test
	void contextLoads() {
		List<OrdDetailDTO> ord = new ArrayList<OrdDetailDTO>();
		ord.add(new OrdDetailDTO(0, 4, 10, 1, 37, 0, null));
		ord.add(new OrdDetailDTO(0, 4, 10, 2, 37, 0, null));
		
		try {
			System.out.println(ord);
			System.out.println("ok");
		} catch (Exception e) {
			System.out.println("fail");
//			e.printStackTrace();
		}
	}

}
