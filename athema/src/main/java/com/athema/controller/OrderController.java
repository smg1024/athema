package com.athema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.athema.dto.OrdDetailDTO;
import com.athema.dto.OrderDTO;
import com.athema.service.ItemService;
import com.athema.service.MemberService;
import com.athema.service.OrdDetailService;
import com.athema.service.OrderService;


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
	public String bookregister(Model model, OrderDTO orderdto,OrdDetailDTO ordDetail, int mem_code, int[] cnt, int[] opt_code) {
		System.out.println("주문등록");
		System.out.println(orderdto);
		OrderDTO obj = null;
		int order_code;
		int exp_days;
		try {
			oservice.register(orderdto);
			System.out.println("order insert ok");
			obj = oservice.onum(mem_code);
			System.out.println(obj);
			order_code = obj.getOrder_code();
			exp_days = orderdto.getExp_days();
			ordDetail.setOrder_code(order_code);
			ordDetail.setOrder_code(order_code);
			ordDetail.setExp_days(exp_days);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("order insert fail");
		}
		
		for(int i=0; i < cnt.length;i++) {
			System.out.println(ordDetail);
			
			try {
				ordDetail.setCnt(cnt[i]);
				ordDetail.setOpt_code(opt_code[i]);
				ordservice.register(ordDetail);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("orderdetail insert ok");
		}
		model.addAttribute("content","index");
		return "main";
	}
}
