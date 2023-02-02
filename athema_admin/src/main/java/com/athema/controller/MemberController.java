package com.athema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.athema.dto.MemberDTO;
import com.athema.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	String dir = "/member/";
	
	@Autowired
	MemberService mservice;
	
	@RequestMapping("/get")
	public String get(Model model) {
		List<MemberDTO> mem_list = null;
		try {
			mem_list = mservice.getall();
		} catch (Exception e) {
			System.out.println("Controller 동작 실패");
			e.printStackTrace();
		}
		model.addAttribute("mem_list", mem_list);
		model.addAttribute("center", dir+"get");
		return "main";
	}

	@RequestMapping("/add")
	public String add(Model model) {
		int todayMem = 0;
		try {
			todayMem = mservice.getTodayMember();
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("todayMem", todayMem);
		model.addAttribute("center", dir+"add");
		return "main";
	}

}
