package com.athema.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.athema.dto.MemberDTO;
import com.athema.service.ItemService;
import com.athema.service.MemberService;
import com.athema.service.OrderService;
import com.google.gson.JsonObject;

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
