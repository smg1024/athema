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

public class ItemDTO {
	private int item_code;
	private String item_name;
	private String item_loc;
	private String item_detail;
	private int cate_code;
	private double lat;
	private double lng;
	private String item_img1;
	private String item_img2;
	private Date rdate;
	private int exp_days;
	
	// 상품의 옵션 정보
	private int opt_code;
	private int item_price;
	private String opt_name;
	
	// 상품의 평균 평점
	private double avg_rating;
	
	// 상품 등록 시 테마 및 지역
	private int theme;
	private String location;
}
