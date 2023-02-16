package com.athema.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
	
	@Autowired
	private PasswordEncoder encoder;
	
	@RequestMapping("/loginimpl")
	public String loginimpl(HttpServletRequest request, HttpSession session, String mem_email, String mem_pwd, Model model) {
		MemberDTO member = null;
		String result = "loginfail";
		String referer = request.getHeader("Referer");
		String local_login = "http://127.0.0.1/login";
		String ncp_login = "http://49.50.166.168/login";
		System.out.println(referer);

		try {
			member = mservice.searchemail(mem_email);
			// 비밀번호 일치
			if((encoder.matches(mem_pwd, member.getMem_pwd())) || (mem_pwd.equals(member.getMem_pwd()))) {
//			if (mem_pwd.equals(member.getMem_pwd())) {
				// 탈퇴하지 않은 멤버
				if (member.getMem_del() == 0) {
					// 소셜로그인이 아니어야 함
					if(member.getProvider() == null) {
						session.setAttribute("loginMember", member);
						result = "index";		// 메인으로 바로 이동
						// 로그인 메뉴로 들어가서 로그인한 경우에는 index 페이지 반환
						if (referer.equals(local_login) || referer.equals(ncp_login)) {
							model.addAttribute("content", result);
							return "main";
						} else {
							return "redirect:"+referer;
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage()+" : 사용자 정보 조회 실패");
			model.addAttribute("content", result);
		}
		model.addAttribute("content", result);
		return "main";
	}
	
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
				String encodedPassword = encoder.encode(member.getMem_pwd());
				member.setMem_pwd(encodedPassword);
				mservice.register(member);
				model.addAttribute("content", "registerok");	/*registerok 페이지로 넘긴다*/
				model.addAttribute("remail", member.getMem_email());	/*입력된 이메일주소를 remail로 넘긴다*/
				model.addAttribute("rnick", member.getMem_nick()); 		/*입력된 닉네임을 rnick으로 넘긴다*/
				model.addAttribute("obj", member);
			}
		} catch (Exception e) {
			model.addAttribute("content", "registerfail");
			model.addAttribute("femail", member.getMem_email());
			e.printStackTrace();
		}
		return "main";
	}
	
	@RequestMapping("/kakaomember")
	public String kakaomember(Model model, MemberDTO member) {
		System.out.println(member.getMem_name());
		System.out.println(member.getMem_email());
		try {
			mservice.modifykakao(member);
			model.addAttribute("content", "registerok");	/*registerok 페이지로 넘긴다*/
			model.addAttribute("remail", member.getMem_email());	/*입력된 이메일주소를 remail로 넘긴다*/
			model.addAttribute("rnick", member.getMem_nick()); 		/*입력된 닉네임을 rnick으로 넘긴다*/
		} catch (Exception e) {
			model.addAttribute("content", "registerfail");	/*registerok 페이지로 넘긴다*/
			model.addAttribute("femail", member.getMem_email());	/*입력된 이메일주소를 remail로 넘긴다*/
			e.printStackTrace();
		}
		return "main";
	}
	
}
