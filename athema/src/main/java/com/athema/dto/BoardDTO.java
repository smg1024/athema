package com.athema.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class BoardDTO {
	// review code
	private int board_code;
	private int mem_code;
	private String board_cate;
	private String board_subject;
	private String board_content;
	private String board_filename;
	private int up_board_code;
	private Date board_rdate;
}
