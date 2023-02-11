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
		
		@RequestMapping("/sales")
		public String sales(Model model) {
			int getMonthOrder=0; // 월 주문건수
			int getDayOrder=0;	// 일 주문건수
			int getYearSales=0;		// 연 매출
			int getMonthSales=0;	// 월 매출
			int getDaySales=0;		// 일 매출
			
			try {
				getMonthOrder=oservice.getMonthOrder();
				getDayOrder=oservice.getDayOrder();
				getYearSales=oservice.getYearSales();
				getMonthSales=oservice.getMonthSales();
				getDaySales=oservice.getDaySales();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			model.addAttribute("getMonthOrder", getMonthOrder);
			model.addAttribute("getDayOrder", getDayOrder);
			model.addAttribute("getYearSales", getYearSales);
			model.addAttribute("getMonthSales", getMonthSales);
			model.addAttribute("getDaySales", getDaySales);
			model.addAttribute("center", dir+"sales");
			return "main";
		}
		
}
