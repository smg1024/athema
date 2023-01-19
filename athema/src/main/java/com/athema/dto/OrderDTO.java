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
	
	public OrderDTO(int order_code, String book_name, String book_hp, String book_email){
		this.order_code = order_code;
		this.book_name = book_name;
		this.book_hp = book_hp;
		this.book_email = book_email;
	}
}
