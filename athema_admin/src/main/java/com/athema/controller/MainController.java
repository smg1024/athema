package com.athema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("")
	public String main() {
		return "main";
	}
	
	@RequestMapping("/index")
	public String index() {
		return "main";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/qna")
	public String qna(Model model) {
		model.addAttribute("center", "qna");
		return "main";
	}
	
	// 주문 관리
	@RequestMapping("/order")
	public String order(Model model) {
		model.addAttribute("center", "order");
		return "main";
	}
}
