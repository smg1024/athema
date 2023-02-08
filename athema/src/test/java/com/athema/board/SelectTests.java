package com.athema.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.athema.dto.BoardDTO;
import com.athema.service.BoardService;


@SpringBootTest
class SelectTests {

	@Autowired
	BoardService service;

	@Test
	void contextLoads() {
		BoardDTO board = null;

		try {
			board = service.get(3);
			System.out.println(board);
			System.out.println("[ OK ]");
		} catch (Exception e) {
			System.out.println("[ FAIL ]");
			e.printStackTrace();
		}

	}

}
