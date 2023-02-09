package com.athema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.athema.service.BoardService;

@Controller
@RequestMapping("/contact")
public class ContactController {
	String dir = "/contact";
	
	@Autowired
	BoardService Bservice;
	
	@RequestMapping("/board_post")
	public String board_post(Model model) {
		
		model.addAttribute("content", "/boardpost");
		return "main";
	}
}
