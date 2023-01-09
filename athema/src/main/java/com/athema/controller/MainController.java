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
	public String tours() {
		return "tours";
	}
	
	@RequestMapping("/blog-default")
	public String blogdefault() {
		return "blog-default";
	}
	
	@RequestMapping("/blog-single")
	public String blogsingle() {
		return "blog-single";
	}
	
	@RequestMapping("/testimonials")
	public String testimonials() {
		return "testimonials";
	}
	
	@RequestMapping("/contact-us")
	public String contactus(Model model) {
		model.addAttribute("center", "contact-us");
		return "index";
	}
	
	@RequestMapping("/styleguide")
	public String styleguide() {
		return "styleguide";
	}
	
	@RequestMapping("/domestic-tour")
	public String domestictour() {
		return "domestic-tour";
	}

	@RequestMapping("/international-tour")
	public String internationaltour() {
		return "international-tour";
	}
	
	@RequestMapping("/asdf")
	public String asdf() {
		return "asdf";
	}
}
