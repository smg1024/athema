package com.athema.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.athema.dto.MemberDTO;
import com.athema.dto.OrderDTO;
import com.athema.dto.ReviewDTO;
import com.athema.dto.WishDTO;
import com.athema.service.MemberService;
import com.athema.service.ReviewService;
import com.athema.service.WishService;

@Controller
@RequestMapping("/mypage")
public class MypageController {
	
	String dir = "mypage/";
	
	@Autowired
	MemberService mservice;
	
	@Autowired
	ReviewService rservice;
	
	@Autowired
	WishService wservice;
	
	@RequestMapping("")
	public String mypage(Model model) {
		model.addAttribute("content", dir+"mypage");	
		model.addAttribute("mypagecenter",dir+ "mypagecenter");
		return "main";
	}
	//http://127.0.0.1/mypage/userpage
	@RequestMapping("/userpage")
	public String userpage(Model model, String mem_email) {
		MemberDTO member = null;
		
		try {
			member = mservice.searchemail(mem_email);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("obj",member);
		System.out.println(member);
		model.addAttribute("content", dir+"mypage");	
		model.addAttribute("mypagecenter",dir+"userpage");
		return "main";
	}
	@RequestMapping("/update")
	public String update(Model model, MemberDTO member) {
		String mem_pwd = member.getMem_pwd();
		System.out.println("비번"+mem_pwd);
		
		if(mem_pwd.equals("") || mem_pwd == null) {
			try {
				mservice.modifybutpass(member);
				System.out.println("비번x 수정성공");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("비번x 수정실패");
				e.printStackTrace();
			}
		}else {
			try {
				mservice.modify(member);
				System.out.println("비번도 수정성공");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("비번도 수정실패");
				e.printStackTrace();
			}
		}
		System.out.println("수정된 값"+member);
		model.addAttribute("obj",member);
		model.addAttribute("content", dir+"mypage");	
		model.addAttribute("mypagecenter",dir+"userpage");
		return "redirect:userpage?mem_email="+member.getMem_email();
	}
	
	 @RequestMapping("/delete")
	 public String delete(Model model, int mem_code) {
		 try { 
			 mservice.remove(mem_code);
			 System.out.println("탈퇴");
		 } catch (Exception e) { 
			 // TODO Auto-generated catch block
			 e.printStackTrace(); 
			 System.out.println("탈퇴x");
		 } 
	 return "redirect:/logout";
	 }
	 
	
	@RequestMapping("/travel_list")
	public String travel_list(Model model) {	
		model.addAttribute("content", dir+"mypage");	
		model.addAttribute("mypagecenter",dir+"travel_list");
		return "main";
	}
	
	@RequestMapping("/travel_plan")
	public String travel_plan(Model model) {	
		model.addAttribute("content", dir+"mypage");	
		model.addAttribute("mypagecenter",dir+"travel_plan");
		return "main";
	}
	
	@RequestMapping("/travel_past")
	public String travel_past(Model model) {	
		model.addAttribute("content", dir+"mypage");	
		model.addAttribute("mypagecenter",dir+"travel_past");
		return "main";
	}
	
	// 리뷰 등록
		@RequestMapping("/insert")
		public String insert(Model model, ReviewDTO review) {
			System.out.println(review);
			try {
				rservice.register(review);	
				System.out.println("등록 성공");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("등록 실패");
			}
			model.addAttribute("content", dir+"mypage");	
			model.addAttribute("mypagecenter",dir+"travel_past");
			return "main";
		}
	
	// 작성한 리뷰 보기
	@RequestMapping("/myreview")
	public String myreview(Model model, int mem_code, String mem_ema) {
		List<ReviewDTO> reviews=null;
		OrderDTO order=null;

		try {
			reviews=rservice.getReviewByMem(mem_code);
			System.out.println("성공");
			System.out.println(reviews);
			model.addAttribute("reviews", reviews);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("실패");
		}
		
		
		model.addAttribute("content", dir+"mypage");	
		model.addAttribute("mypagecenter",dir+"myreview");
		
		return "main";
	}
	
	// 리뷰 삭제
	@RequestMapping("/rremove")
	public void rremove(Model model, int review_code) {
		try {
			rservice.remove(review_code);
			System.out.println("삭제 성공");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("삭제 실패");
		}
	}
	
	// 나의 위시리스트
	@RequestMapping("/mywishlist")
	public String mywishlist(Model model, int wish_code) {	
		List<WishDTO> wishs = null;
		
		try {
			wishs = wservice.getall();
			for (WishDTO r : wishs) {
				System.out.println(r);
			} System.out.println("OK");
		}	catch (Exception e) {
			System.out.println("Failed");
			e.printStackTrace();
		}
	
		model.addAttribute("content", dir+"mypage");	
		model.addAttribute("mypagecenter",dir+"mywishlist");
		return "main";
	}
	
}
