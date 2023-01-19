package com.athema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.athema.dto.MemberDTO;
import com.athema.service.MemberService;

@RestController
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	MemberService mservice;
	
	@RequestMapping("/kakao")
	public void callback(@RequestParam String code) {
		System.out.println(code);
		
		// Post 방식으로 Access Token 요청하기 (key=value)
		RestTemplate rt = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", "authorization_code");
		params.add("client_id", "9740cda4f593e49b4bf7b3235435574d");
		params.add("redirect_uri", "http://127.0.0.1/member/kakao");
		params.add("code", code);
		
		// rt에 HttpHeader와 HttpBody 모두를 한번에 담아주기 위해 HttpEntity 객체 생성
		HttpEntity<MultiValueMap<String, String>> kakaoTokenReq = new HttpEntity<>(headers, params);
		
		// HttpEntity를 담아서 post방식으로 http 요청 및 응답 저장
		ResponseEntity<String> kakaoTokenRes = rt.exchange("https://kauth.kakao.com/oauth/token", HttpMethod.POST, kakaoTokenReq, String.class);
		
		// 이후 어떻게 추출? -> 아직 작성 못함
		
	}
	
	@RequestMapping("/welcome")
	public String welcome(Model model) {
		model.addAttribute("content", "welcome");
		return "main";
	}
	
	@RequestMapping("/checkemail")
	public int checkemail(MemberDTO email) {
		int result = 0;
		try {
			result = mservice.getemail(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	
}
