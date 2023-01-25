package com.athema.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.athema.dto.MemberDTO;
import com.athema.service.KakaoService;
import com.athema.service.MemberService;

@Controller
@RequestMapping("/oauth")
public class OauthController {
	
	@Autowired
	MemberService mservice;
	
	@Autowired
	KakaoService kakao;
	
	@RequestMapping("/kakao")
	public String kakaologin(@RequestParam String code, Model model, HttpSession session) {
		// 인가코드 확인
		System.out.println("인가코드 : "+code);
		// 작성한 KakaoService에서 인가코드 넣고 액세스토큰 불러오는 메소드 호출
		String access_token = kakao.getAccessToken(code);
		System.out.println("Access token after controller : "+ access_token);
		// 작성한 KakaoService에서 액세스토큰 넣고 사용자 정보 불러오는 메소드 호출
		HashMap<String, Object> userInfo = kakao.getUserInfo(access_token);
		System.out.println("UserInfo after controller : " + userInfo);
		
		Object nickname = userInfo.get("nickname");
		String mem_nick = String.valueOf(nickname); /* String으로 변환하여 저장 */
		System.out.println(mem_nick + " : 닉네임 String 변환 테스트 중..");
		
		Object email = userInfo.get("email");
		String mem_email = String.valueOf(email);
		System.out.println(mem_email + " : 이메일 String 변환 테스트 중..");
		
		// DB에 해당 값 저장하기 (회원가입 절차)
		String provider = "kakao";
		MemberDTO member = null;
		try {
			int cnt = mservice.getemail(mem_email);
			member = mservice.searchemail(mem_email);
			if(cnt > 0) {
				System.out.println("탈퇴 및 중복회원");
				model.addAttribute("content", "registerfail");
				model.addAttribute("femail", mem_email);
				return "main";
			} else {		// 가입한 적 없는 회원, 아직 null 상태
				member = new MemberDTO();
				member.setMem_email(mem_email);
				member.setMem_nick(mem_nick);
				member.setProvider(provider);
				mservice.register(member);
				
				// 프린트 찍어보기
				MemberDTO newKakaoMem = mservice.searchemail(mem_email);
				System.out.println(newKakaoMem);
				
				// session에 로그인 정보 저장
				session.setAttribute("loginMember", newKakaoMem);
				
				// 나중에 추가폼 페이지 만들어지면 수정할 것
				model.addAttribute("content", "registerok");
				model.addAttribute("rnick", mem_nick);
				model.addAttribute("remail", mem_email);
				return "main";
			}
		} catch (Exception e) {
			System.out.println("이메일조회 실패");
			e.printStackTrace();
			return "main";
		}
	}
	
}
