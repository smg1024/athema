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
	private float score;
	private Date review_date;
	private String review_img;
	
	private String mem_nick;
	
	public ReviewDTO(int review_code, int mem_code, int item_code, String title, String content, float score, Date review_date, String review_img){
		this.review_code = review_code;
		this.mem_code = mem_code;
		this.item_code = item_code;
		this.title = title;
		this.content = content;
		this.score = score;
		this.review_date = review_date;
		this.review_img = review_img;
	}
}
