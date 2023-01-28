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
		model.addAttribute("mypageleft", "left");	//왼쪽이 mypageleft.html 가져오겠다 오른쪽이 mypage.html에서 쓰는 이름
		model.addAttribute("mypagecenter", "center");
		return "main";
	}
	
}
