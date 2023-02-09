package com.athema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.athema.service.ItemService;
import com.athema.service.MemberService;
import com.athema.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService oservice;
	
	@Autowired
	ItemService iservice;
	
	@Autowired
	MemberService mservice;

	
	@RequestMapping("/bookregister")
	public String bookregister() {
		return null;
	}

}
