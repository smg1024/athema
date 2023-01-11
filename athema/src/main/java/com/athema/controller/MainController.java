package com.athema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/about")
	public String about() {
		return "about";
	}
	
	@RequestMapping("/offers")
	public String tours() {
		return "offers";
	}
	
	@RequestMapping("/blog")
	public String blogdefault() {
		return "blog";
	}
	
	@RequestMapping("/contact")
	public String blogsingle() {
		return "contact";
	}
	
	@RequestMapping("/asdf")
	public String asdf(Model model) {
		return "asdf";
	}
	
}
