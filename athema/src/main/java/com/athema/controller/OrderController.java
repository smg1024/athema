package com.athema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.athema.service.ItemService;
import com.athema.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService oservice;
	
	@Autowired
	ItemService iservice;

	@RequestMapping("/book_options")
	public String book_options(int mem_code, int item_code, 
			@RequestParam List<Integer> opt_codes, 
			@RequestParam List<Integer> opt_quantities) {
		System.out.println(mem_code);
		System.out.println(item_code);
		System.out.println(opt_codes);
		System.out.println(opt_quantities);
		
		return "main";
	}

}
