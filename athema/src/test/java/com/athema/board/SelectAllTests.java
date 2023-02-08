package com.athema.board;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.athema.dto.BoardDTO;
import com.athema.service.BoardService;


@SpringBootTest
class SelectAllTests {

	@Autowired
	BoardService service;

	@Test
	void contextLoads() {
		List<BoardDTO> boards = null;

		try {

			boards = service.getall();
			for (BoardDTO b : boards) {
				System.out.println(b);
			}
			System.out.println("[ OK ]");
		} catch (Exception e) {
			System.out.println("[ FAIL ]");
			e.printStackTrace();
		}

	}

}
