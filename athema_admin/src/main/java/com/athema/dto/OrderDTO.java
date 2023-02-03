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
	private int detail_code;
	private String mem_name;
	private int tot_price;
	private Date order_date;
	private String book_name;
	private String book_hp;
	private String book_email;
	private String item_name;
	private String opt_name;
	private int cnt;
	private Date exp_date;
	private int used;
}
