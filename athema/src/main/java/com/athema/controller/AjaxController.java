package com.athema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.athema.dto.WishDTO;
import com.athema.service.MemberService;
import com.athema.service.OptionService;
import com.athema.service.WishService;

@RestController
public class AjaxController {
	
	@Autowired
	MemberService mservice;
	
	@Autowired
	OptionService oservice;
	
	@Autowired
	WishService wservice;
	
	// 이메일 중복체크
	@RequestMapping("/checkemail")
	public int checkemail(String email) {
		int result = 0;
		try {
			// 이메일 조회되면 cnt값이 result에 반영됨
			result = mservice.getemail(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// 상품 담을때 가격 표시
	@RequestMapping("/getprice")
	public int getprice(int item_code, int opt_code, int opt_quantity) {
		int price = 0;
		
		try {
			price = oservice.getprice(item_code, opt_code, opt_quantity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return price;
	}
	
	// 위시리스트 담기
	@RequestMapping("/add_wishlist")
	public void add_wishlist(int item_code, int mem_code) {
		WishDTO wishlist = new WishDTO(item_code, mem_code);
		System.out.println(wishlist);
		
		try {
			wservice.register(wishlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 위시리스트 빼기
	@RequestMapping("/del_wishlist")
	public int del_wishlist(int item_code, int mem_code) {
		int result = 0;
		
		try {
			wservice.del_wishlist(item_code, mem_code);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
