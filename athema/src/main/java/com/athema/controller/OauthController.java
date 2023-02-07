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
import com.athema.service.NaverService;

@Controller
@RequestMapping("/oauth")
public class OauthController {
	
	@Autowired
	MemberService mservice;
	
	@Autowired
	KakaoService kakao;
	
	@Autowired
	NaverService naver;
	
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
				// 해당 이메일이 탈퇴하지 않았고 소셜 로그인 회원이면 세션 로그인
				if (member.getMem_del() == 0 && member.getProvider() != null) {
					System.out.println("탈퇴코드: " + member.getMem_del() + ", 서비스 제공자: " + member.getProvider());
					session.setAttribute("loginMember", member);
					System.out.println("로그인 정보 : "+member);
					model.addAttribute("content", "index");
					return "main";
				} else {
					// 탈퇴한 회원은 일정 시간 지날 때까지 재가입 불가
					System.out.println("탈퇴 및 중복회원");
					model.addAttribute("content", "registerfail");
					model.addAttribute("femail", mem_email);
					return "main";
				}
			} else {		// 가입한 적 없는 회원, 아직 null 상태
				member = new MemberDTO();
				/* 가입 완료상태에서 새로고침하여 null값 DB에 저장되는 것 방지하기
				 Object > String.valueOf() 거치면서 두 컬럼 모두 String값이 됨 */
				if (mem_email != "null" && mem_nick != "null") {
					member.setMem_email(mem_email);
					member.setMem_nick(mem_nick);
					member.setProvider(provider);
					mservice.register(member);
					System.out.println("새 소셜회원 DB 등록 & 회원가입 완료");
				} else {
					System.out.println("null값 DB 저장 방지용..");
					model.addAttribute("content", "index");
					return "main";				}
				
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
			model.addAttribute("content", "login");
			return "main";
		}
	}
	
	@RequestMapping("/naver")
	public String naverlogin(@RequestParam String code, String state, Model model, HttpSession session) {
		// 인가코드 확인
		System.out.println("인가코드 : "+code);
		// 작성한 NaverService에서 인가코드 넣고 액세스토큰 불러오는 메소드 호출
		String access_token = naver.getAccessToken(code, state);
		System.out.println("Access token after controller : "+ access_token);
		// 작성한 NaverService에서 액세스토큰 넣고 사용자 정보 불러오는 메소드 호출
		HashMap<String, Object> userInfo = naver.getUserInfo(access_token);
		System.out.println("UserInfo after controller : " + userInfo);
		
		Object nickname = userInfo.get("nickname");
		String mem_nick = String.valueOf(nickname); /* String으로 변환하여 저장 */
		System.out.println(mem_nick + " : 닉네임 String 변환 테스트 중..");
		
		Object email = userInfo.get("email");
		String mem_email = String.valueOf(email);
		System.out.println(mem_email + " : 이메일 String 변환 테스트 중..");
		
		Object name = userInfo.get("name");
		String mem_name = String.valueOf(name);
		System.out.println(mem_name + " : 이름 String 변환 테스트 중..");
		
		Object birthday = userInfo.get("birthday");
		String mem_birthday = String.valueOf(birthday);
		System.out.println(mem_birthday + " : 생일 String 변환 테스트 중..");
		
		Object birthyear = userInfo.get("birthyear");
		String mem_birthyear = String.valueOf(birthyear);
		System.out.println(mem_birthyear + " : 출생년도 String 변환 테스트 중..");
		
		String mem_birth = mem_birthyear + "-" +mem_birthday;
		System.out.println(mem_birth + " : 생년월일 입력 테스트 중..");
		
		Object mobile = userInfo.get("mobile");
		String mem_hp = String.valueOf(mobile);
		System.out.println(mem_hp + " : 휴대폰 String 변환 테스트 중..");
		
		// DB에 해당 값 저장하기 (회원가입 절차)
		String provider = "naver";
		MemberDTO member = null;
		try {
			int cnt = mservice.getemail(mem_email);
			member = mservice.searchemail(mem_email);
			if(cnt > 0) {
				// 해당 이메일이 탈퇴하지 않았고 소셜 로그인 회원이면 세션 로그인
				if (member.getMem_del() == 0 && member.getProvider() != null) {
					System.out.println("탈퇴코드: " + member.getMem_del() + ", 서비스 제공자: " + member.getProvider());
					session.setAttribute("loginMember", member);
					System.out.println("로그인 정보 : "+member);
					model.addAttribute("content", "index");
					return "main";
				} else {
					// 탈퇴한 회원은 일정 시간 지날 때까지 재가입 불가
					System.out.println("탈퇴 및 중복회원");
					model.addAttribute("content", "registerfail");
					model.addAttribute("femail", mem_email);
					return "main";
				}
			} else {		// 가입한 적 없는 회원, 아직 null 상태
				member = new MemberDTO();
				/* 가입 완료상태에서 새로고침하여 null값 DB에 저장되는 것 방지하기
				 Object > String.valueOf() 거치면서 두 컬럼 모두 String값이 됨 */
				if (mem_email != "null" && mem_nick != "null") {
					member.setMem_name(mem_name);
					member.setMem_email(mem_email);
					member.setMem_nick(mem_nick);
					member.setMem_birth(mem_birth);
					member.setMem_hp(mem_hp);
					member.setProvider(provider);
					mservice.register(member);
					System.out.println("새 소셜회원 DB 등록 & 회원가입 완료");
				} else {
					System.out.println("null값 DB 저장 제한..");
					model.addAttribute("content", "index");
					return "main";				}
				
				// 프린트 찍어보기
				MemberDTO newNaverMem = mservice.searchemail(mem_email);
				System.out.println(newNaverMem);
				
				// session에 로그인 정보 저장
				session.setAttribute("loginMember", newNaverMem);
				
				// 나중에 추가폼 페이지 만들어지면 수정할 것
				model.addAttribute("content", "registerok");
				model.addAttribute("rnick", mem_nick);
				model.addAttribute("remail", mem_email);
				return "main";
			}
		} catch (Exception e) {
			System.out.println("이메일조회 실패");
			e.printStackTrace();
			model.addAttribute("content", "login");
			return "main";
		}
	}
	
}
