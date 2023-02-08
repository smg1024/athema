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


public class WishDTO {
	private int wish_code;
	private int item_code;
	private int mem_code;
	
	public WishDTO(int item_code, int mem_code) {
		this.item_code = item_code;
		this.mem_code = mem_code;
	}
}
