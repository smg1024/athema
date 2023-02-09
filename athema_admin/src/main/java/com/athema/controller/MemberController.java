package com.athema.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
	public String get(Model model) throws Exception {
		List<MemberDTO> mem_list = null;
		try {
			mem_list = mservice.getall();
		} catch (Exception e) {
			System.out.println("Controller 동작 실패");
			e.printStackTrace();
			throw new Exception("회원 조회 에러");
		}
		model.addAttribute("mem_list", mem_list);
		model.addAttribute("center", dir+"get");
		return "main";
	}

	@RequestMapping("/add")
	public String add(Model model) throws Exception  {
		int todayMem = 0;
		int weekMem = 0;
		int monthMem = 0;
		int totMem = 0;		// 총 누적 가입 회원
		int yesterMem = 0;	// 어제 가입한 회원
		int perday = 0;		// 전일 대비 증감율
		
		int todayWithdraw = 0;		// 오늘 탈퇴한 회원
		int monthWithdraw = 0;		// 당월 탈퇴한 회원
		int totWithdraw = 0;		// 총 탈퇴 회원
		
		try {
			todayMem = mservice.getTodayMember();
			weekMem = mservice.getWeekMember();
			monthMem = mservice.getMonthMember();
			totMem = mservice.getTotMember();
			yesterMem = mservice.getYesterdayMember();
			todayWithdraw = mservice.getTodayWithdraw();
			monthWithdraw = mservice.getMonthWithdraw();
			totWithdraw = mservice.getTotWithdraw();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("회원 조회 실패");
		}
		
		// 증감율 계산
		if (yesterMem == 0) {
			perday = todayMem * 100;
		} else if (todayMem == yesterMem) {
			perday = 0;
		} else {
			perday = (todayMem - yesterMem)/yesterMem * 100;
		}
		
		model.addAttribute("totWithdraw", totWithdraw);
		model.addAttribute("monthWithdraw", monthWithdraw);
		model.addAttribute("todayWithdraw", todayWithdraw);
		model.addAttribute("perday", perday);
		model.addAttribute("todayMem", todayMem);
		model.addAttribute("weekMem", weekMem);
		model.addAttribute("monthMem", monthMem);
		model.addAttribute("totMem", totMem);
		model.addAttribute("center", dir+"add");
		return "main";
	}
	
	@RequestMapping("/adloginimpl")
	public String loginimpl (HttpSession session, String mem_email, String mem_pwd, Model model) throws Exception{
		MemberDTO member = null;
		String result = "loginfail";
		try {
			member = mservice.searchemail(mem_email);
			// 비밀번호 일치
			if (mem_pwd.equals(member.getMem_pwd())) {
				// 관리자 확인
				if(member.getMem_auth() == 'A') {
					// 탈퇴하지 않은 멤버
					if (member.getMem_del() == 0) {
						// 소셜로그인이 아니어야 함
						if(member.getProvider() == null) {
							session.setAttribute("loginAdmin", member);
							result = "center";
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage()+" : 사용자 정보 조회 실패");
			throw new Exception("회원 정보가 없습니다.");
		}
		model.addAttribute("center", result);
		return "main";
	}
}
