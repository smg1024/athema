package com.athema.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.athema.dto.OrdDetailDTO;
import com.athema.dto.OrderDTO;
import com.athema.service.ItemService;
import com.athema.service.MemberService;
import com.athema.service.OrdDetailService;
import com.athema.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
@RequestMapping("/order")
public class OrderController {
	
	
	@Autowired
	OrderService oservice;
	
	@Autowired
	OrdDetailService ordservice;
	
	@Autowired
	ItemService iservice;
	
	@Autowired
	MemberService mservice;
	
	@RequestMapping("/bookregister")
	public String bookregister(Model model, OrderDTO orderdto, int mem_code) {
		System.out.println("주문등록");
		System.out.println(orderdto);
		OrderDTO obj = null;
		try {
			oservice.register(orderdto);
			System.out.println("order insert ok");
			obj = oservice.onum(mem_code);
			System.out.println(obj);
			return "redirect:http://49.50.166.168/";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("order insert fail");
		}
		return "main";
	}
	@RequestMapping("/detailregister")
	public String detailregister(Model model, @RequestParam Map<Integer, OrdDetailDTO> OrdDetailDTOs) {
		String json = OrdDetailDTOs.get("jsonData").toString();
	    ObjectMapper mapper = new ObjectMapper();
	    List<Map<String, Object>> OrdDetailDTO = mapper.readValue(json, new TypeReference<ArrayList<Map<String, Object>>>(){});
		List<OrdDetailDTO> ord = new ArrayList<OrdDetailDTO>();
		System.out.println("주문상세등록");
		System.out.println(OrdDetailDTOs);
		ord.addAll(OrdDetailDTOs);
		System.out.println(ord);
		try {
			
			ordservice.ordinsert(ord);
			System.out.println("orderdetail insert ok");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ordDetail insert fail");
		}
		return "main";
	}

}
