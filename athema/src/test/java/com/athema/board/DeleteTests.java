package com.athema.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.athema.service.BoardService;



@SpringBootTest
class DeleteTests {

	@Autowired
	BoardService service;

	@Test
	void contextLoads() {
		try {
			service.remove(2);
			System.out.println("[ OK ]");
		} catch (Exception e) {
			System.out.println("[ FAIL ]");
			e.printStackTrace();
		}

	}

}
