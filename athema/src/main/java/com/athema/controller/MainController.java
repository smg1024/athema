package com.athema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.athema.dto.ItemDTO;
import com.athema.service.ItemService;

@Controller
public class MainController {
	
	@Autowired
	ItemService iservice;
	
	@RequestMapping("")
	public String main() {
		return "index";
	}
	
	@RequestMapping("/main")
	public String main2() {
		return "index";
	}

	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("content", "login");
		return "main";
	}
	
	@RequestMapping("/register")
	public String register(Model model) {
		model.addAttribute("content", "register");
		return "main";
	}
	
	@RequestMapping("/about")
	public String about(Model model) {
		model.addAttribute("content", "about");
		return "main";
	}
	
	@RequestMapping("/offers")
	public String offers(Model model) {
		List<ItemDTO> list = null;
		
		try {
			list = iservice.getall();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("itemlist", list);
		model.addAttribute("content", "offers");
		return "main";
	}
	
	@RequestMapping("/blog")
	public String blog(Model model) {
		model.addAttribute("content", "blog");
		return "main";
	}
	
	@RequestMapping("/contact")
	public String contact(Model model) {
		model.addAttribute("content", "contact");
		return "main";
	}
	
	@RequestMapping("/elements")
	public String elements(Model model) {
		model.addAttribute("content", "elements");
		return "main";
	}

	@RequestMapping("/single_listing")
	public String single_listing(Model model) {
		model.addAttribute("content", "single_listing");
		return "main";
	}
	
	@RequestMapping("/order")
	public String order(Model model) {
		model.addAttribute("content", "order");
		return "main";
	}
	
	@RequestMapping("/order_detail")
	public String order_detail(Model model) {
		model.addAttribute("content", "order_detail");
		return "main";
	}
	
}
