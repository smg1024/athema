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
public class ReviewDTO {
	// review code
	private int review_code;
	private int mem_code;
	private int item_code;
	private String title;
	private String content;
	private int score;
	private Date review_date;
	private String review_img;
}
