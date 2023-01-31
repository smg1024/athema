package com.athema.dto;

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


public class OptionDTO {
	private int opt_code;
	private int item_code;
	private String opt_name;
	private int item_price;
	
}