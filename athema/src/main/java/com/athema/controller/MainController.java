package com.athema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("/index")
	public String index(Model model) {
		model.addAttribute("center", "maincenter");
		return "index";
	}
	
	@RequestMapping("/about")
	public String about() {
		
		return "about";
	}
	
	@RequestMapping("/tours")
	public String tours(Model model) {
		model.addAttribute("center", "tours");
		return "index";
	}
	
	@RequestMapping("/blog-default")
	public String blogdefault(Model model) {
		model.addAttribute("center", "blog-default");
		return "index";
	}
	
	@RequestMapping("/blog-single")
	public String blogsingle(Model model) {
		model.addAttribute("center", "blog-single");
		return "index";
	}
	
	@RequestMapping("/testimonials")
	public String testimonials(Model model) {
		model.addAttribute("center", "testimonials");
		return "index";
	}
	
	@RequestMapping("/contact-us")
	public String contactus(Model model) {
		model.addAttribute("center", "contact-us");
		return "index";
	}
	
	@RequestMapping("/styleguide")
	public String styleguide(Model model) {
		model.addAttribute("center", "styleguide");
		return "index";
	}
	
	@RequestMapping("/domestic-tour")
	public String domestictour(Model model) {
		model.addAttribute("center", "domestic-tour");
		return "index";
	}

	@RequestMapping("/international-tour")
	public String internationaltour(Model model) {
		model.addAttribute("center", "international-tour");
		return "index";
	}
	
	@RequestMapping("/asdf")
	public String asdf(Model model) {
		return "asdf";
	}
	
}
