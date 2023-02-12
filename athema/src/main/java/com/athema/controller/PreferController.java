package com.athema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.athema.dto.MemberDTO;
import com.athema.dto.PreferDTO;
import com.athema.service.MemberService;
import com.athema.service.PreferService;

@Controller
@RequestMapping("/prefer")
public class PreferController {
	
	@Autowired
	PreferService pservice;
	
	@Autowired
	MemberService mservice;
	
	@RequestMapping("/addprefer")
	public String addprefer(Model model, int[] cate, PreferDTO dto, String mem_email) {
		
		MemberDTO mem;
		int mem_code;
		try {
			mem = mservice.searchemail(mem_email);	// input th:value값 이메일로 dto 불러오기
			mem_code = mem.getMem_code();	// 
			System.out.println("멤버코드 받아오기 성공 : "+mem_code);
			dto.setMem_code(mem_code);	// prefer에 mem_code 입력
			System.out.println("prefer에 mem_code 입력 완료");
		} catch (Exception e1) {
			e1.printStackTrace();
			System.out.println("멤버코드 받아오기 실패");
			model.addAttribute("content", "index");
			return "main";
		}
		
		if (cate==null) {	
			System.out.println("선호코드 선택 안함");
			model.addAttribute("content", "index");
			return "main";
		}
		for (int i = 0; i < cate.length; i++) {
            System.out.println("선호코드 "+i+"번째 :"+cate[i]);	// 선호 테마 확인
	    }
		int cate_code = 0;
		int cate_code2 = 0;
		if (cate.length==1) {	// 1개 선택
			cate_code = cate[0];
			dto.setCate_code(cate_code);
			System.out.println("cate_code : "+cate_code);
			try {
				pservice.register(dto);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("1개 등록 실패");
			}
			System.out.println("cate_code 1개 선택");
		}
		
		if (cate.length==2) {	// 2개 선택
			cate_code = cate[0];
			cate_code2 = cate[1];
			dto.setCate_code(cate_code);
			dto.setCate_code2(cate_code2);
			System.out.println("cate_code : "+ cate_code + ", " + cate_code2);
			try {
				pservice.register(dto);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("2개 등록 실패");
			}
			System.out.println("cate_code 2개 선택");
		}
		
		model.addAttribute("content", "login");
		return "main";
	}
}
