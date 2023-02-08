package com.athema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.athema.service.BoardService;

@Controller
@RequestMapping("/contact")
public class ContactController {

	@Autowired
	BoardService Bservice;
	
	@RequestMapping("/list")
	public String kk() {
		
		return "main";
	}
}
