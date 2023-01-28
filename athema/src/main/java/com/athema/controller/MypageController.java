package com.athema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage")
public class MypageController {
	
	String dir = "mypage/";
	
	@RequestMapping("")
	public String mypage(Model model) {
		model.addAttribute("content", "mypage");	
		model.addAttribute("mypagecenter", "mypagecenter");
		return "main";
	}
	//http://127.0.0.1/mypage/userpage
	@RequestMapping("/userpage")
	public String userpage(Model model) {	
		model.addAttribute("content", "mypage");	
		model.addAttribute("mypagecenter",dir+"userpage");
		return "main";
	}
	
	@RequestMapping("/travel_list")
	public String travel_list(Model model) {	
		model.addAttribute("content", "mypage");	
		model.addAttribute("mypagecenter",dir+"travel_list");
		return "main";
	}
	
	@RequestMapping("/travel_plan")
	public String travel_plan(Model model) {	
		model.addAttribute("content", "mypage");	
		model.addAttribute("mypagecenter",dir+"travel_plan");
		return "main";
	}
	
	@RequestMapping("/travel_past")
	public String travel_past(Model model) {	
		model.addAttribute("content", "mypage");	
		model.addAttribute("mypagecenter",dir+"travel_past");
		return "main";
	}
	
	@RequestMapping("/myreview")
	public String myreview(Model model) {	
		model.addAttribute("content", "mypage");	
		model.addAttribute("mypagecenter",dir+"myreview");
		return "main";
	}
	
	@RequestMapping("/mywishlist")
	public String mywishlist(Model model) {	
		model.addAttribute("content", "mypage");	
		model.addAttribute("mypagecenter",dir+"mywishlist");
		return "main";
	}
	
}
