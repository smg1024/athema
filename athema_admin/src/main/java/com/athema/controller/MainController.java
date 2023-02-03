package com.athema.controller;

import javax.servlet.http.HttpSession;

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
	
	@RequestMapping("/logout")
	public String logout(HttpSession session, Model model) {
		if(session != null) {
			session.invalidate();
		}
		model.addAttribute("content", "center");
		return "main";
	}
	
	@RequestMapping("/qna")
	public String qna(Model model) {
		model.addAttribute("center", "qna");
		return "main";
	}
	
}
