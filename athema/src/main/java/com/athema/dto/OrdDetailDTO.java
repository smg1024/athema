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
public class OrdDetailDTO {
	private int detail_code;
	private int cnt;
	private Date exp_date;
	private int opt_code;
	private int order_code;
	private int used;
	private Date user_date;
	private int exp_num;	//만료일자 mysql 방식으로 넣으면 에러나서 숫자만 해줬어요
	
	public OrdDetailDTO(int detail_code, Integer cnt,int exp_num, Integer opt_code, int order_code, int used, Date user_date) {
		this.detail_code =detail_code;
		this.cnt=cnt;
		this.exp_num=exp_num;
		this.opt_code=opt_code;
		this.order_code=order_code;
		this.used=used;
		this.user_date=user_date;
	}
	
	public OrdDetailDTO(int detail_code, Integer cnt, int used) {
		this.detail_code =detail_code;
		this.cnt=cnt;
		this.used=used;
	}
	
}