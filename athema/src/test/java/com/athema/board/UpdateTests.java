package com.athema.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.athema.dto.BoardDTO;
import com.athema.service.BoardService;


@SpringBootTest
class UpdateTests {

	@Autowired
	BoardService service;

	@Test
	void contextLoads() {
		BoardDTO board = new BoardDTO();
			board.setBoard_code(2);
			board.setMem_code(3);
			board.setBoard_subject("수정문의드립니다2222");
			board.setBoard_content("미안하다 이거 보여주려고 어그로 끌었다2222");
			board.setBoard_filename("editfile222.jpg");
		try {
			service.modify(board);
			System.out.println(board);
			System.out.println("[ OK ]");
		} catch (Exception e) {
			System.out.println("[ FAIL ]");
			e.printStackTrace();
		}

	}

}
