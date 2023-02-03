package com.athema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.athema.dto.OrderDTO;
import com.athema.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	String dir = "/order/";
	
	@Autowired
	OrderService oservice;
	
		// 주문 관리
		@RequestMapping("/get")
		public String order(Model model) {
			List<OrderDTO> list = null;
			
			try {
				list = oservice.listall();
				/* System.out.println("주문목록 출력 성공"); */
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			model.addAttribute("list",list);
			model.addAttribute("center", dir+"get");
			return "main";
		}
		
		
		
		@RequestMapping("/delete")
		public String delete(Model model) {
			List<OrderDTO> list = null;
			try {
				list = oservice.listall();
				/* System.out.println("주문목록 출력 성공"); */
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			model.addAttribute("list",list);
			model.addAttribute("center", dir+"delete");
			return "main";
		}
}
