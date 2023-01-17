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
public class MemberDTO {
	private int mem_code;
	private String mem_email;
	private String mem_pwd;
	private String mem_name;
	private String mem_hp;
	private String mem_nick;
	private String mem_birth;
	private Date mem_date;
	private char mem_auth;
	private int mem_del;
	private Date mem_deldate;
	private String provider;
}
