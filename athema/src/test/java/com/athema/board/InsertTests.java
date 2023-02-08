package com.athema.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.athema.dto.BoardDTO;
import com.athema.service.BoardService;


@SpringBootTest
class InsertTests {

	@Autowired
	BoardService service;

	@Test
	void contextLoads() {								
		BoardDTO board = new BoardDTO();
		board.setMem_code(3);
		board.setBoard_cate("FAQ");
		board.setBoard_subject("문의드립니다222222");
		board.setBoard_content("환불좀2222222");
		board.setBoard_filename("attachment222222.jpg");
		try {
			service.register(board);
			System.out.println("[OK]");
		} catch (Exception e) {
			System.out.println("[ FAIL ]");
			e.printStackTrace();
		}

	}

}
