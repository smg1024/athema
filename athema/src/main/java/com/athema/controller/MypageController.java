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

		return "main";
	}
	
}
