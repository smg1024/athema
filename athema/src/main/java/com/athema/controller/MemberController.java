package com.athema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@RequestMapping("/welcome")
	public String welcome(Model model) {
		model.addAttribute("content", "welcome");
		return "main";
	}
	

	
}
