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
public class OrderDTO {
	private int order_code;
	private int mem_code;
	private int tot_price;
	private Date order_date;
	private int pay_code;
	private String book_name;
	private String book_hp;
	private String book_email;
	
	// 마이페이지 여행 보기 위해 필요
	private String item_name;
	private int opt_code; 
	private String opt_name;
	private int cnt;
	private Date exp_date;
	private Date used_date;
	
	
	public OrderDTO(int order_code, String book_name, String book_hp, String book_email){
		this.order_code = order_code;
		this.book_name = book_name;
		this.book_hp = book_hp;
		this.book_email = book_email;
	}
	
	public OrderDTO(int order_code, int mem_code, int tot_price, Date order_date, int pay_code, String book_name, String book_hp, String book_email){
		this.order_code = order_code;
		this.mem_code = mem_code;
		this.tot_price = tot_price;
		this.order_date = order_date;
		this.pay_code = pay_code;
		this.book_name = book_name;
		this.book_hp = book_hp;
		this.book_email = book_email;
	}
}
