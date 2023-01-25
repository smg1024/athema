package com.athema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.athema.dto.MemberDTO;
import com.athema.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	MemberService mservice;

	@RequestMapping("/addmember")
	public String addmember(Model model, MemberDTO member) {
		int cnt = 0;
		try {
			System.out.println(member);
//			이메일 DB조회 > 중복되면 값 넘어가지 않게 하기
			cnt = mservice.getemail(member.getMem_email());
			if (cnt > 0) {
//				조회된 이메일이 1개 이상
				model.addAttribute("content", "registerfail");	/*registerfail 페이지로 넘긴다*/
				model.addAttribute("femail", member.getMem_email()); 	/*입력된 이메일주소를 femail로 넘긴다*/
			} else {
				mservice.register(member);
				model.addAttribute("content", "registerok");	/*registerok 페이지로 넘긴다*/
				model.addAttribute("remail", member.getMem_email());	/*입력된 이메일주소를 remail로 넘긴다*/
				model.addAttribute("rnick", member.getMem_nick()); 		/*입력된 닉네임을 rnick으로 넘긴다*/
			}
		} catch (Exception e) {
			model.addAttribute("content", "registerfail");
			model.addAttribute("femail", member.getMem_email());
			e.printStackTrace();
		}
		return "main";
	}
	
}
