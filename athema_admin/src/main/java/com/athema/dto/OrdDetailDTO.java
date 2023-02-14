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
	private Integer opt_code;
	private int order_code;
	private int used;
	private Date used_date;
	private int exp_days;	//만료일자 mysql 방식으로 넣으면 에러나서 숫자만 해줬어요
	
	public OrdDetailDTO(int detail_code, int cnt,int exp_days, int opt_code, Integer order_code, int used, Date used_date) {
		this.detail_code =detail_code;
		this.cnt=cnt;
		this.exp_days=exp_days;
		this.opt_code=opt_code;
		this.order_code=order_code;
		this.used=used;
		this.used_date=used_date;
	}
	
	public OrdDetailDTO(int detail_code, int cnt, int used) {
		this.detail_code =detail_code;
		this.cnt=cnt;
		this.used=used;
	}
	
}