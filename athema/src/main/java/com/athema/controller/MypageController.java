package com.athema.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.athema.dto.MemberDTO;
import com.athema.dto.OrdDetailDTO;
import com.athema.dto.OrderDTO;
import com.athema.dto.ReviewDTO;
import com.athema.dto.WishDTO;
import com.athema.frame.Util;
import com.athema.service.MemberService;
import com.athema.service.OrdDetailService;
import com.athema.service.OrderService;
import com.athema.service.ReviewService;
import com.athema.service.WishService;

@Controller
@RequestMapping("/mypage")
public class MypageController {
	
	String dir = "mypage/";
	
	@Value("${admindir}")
	String admindir;
	
	@Value("${custdir}")
	String custdir;
	
	@Autowired
	MemberService mservice;
	
	@Autowired
	ReviewService rservice;
	
	@Autowired
	WishService wservice;
	
	@Autowired
	OrderService oservice;
	
	@Autowired
	OrdDetailService ordservice;
	
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
	 
	// 여행 관리
	@RequestMapping("/travel_list")
	public String travel_list(Model model, int mem_code) {	
		List<OrderDTO> orders=null;
		List<OrderDTO> porder = null;
		
		try {
			orders=oservice.getTravelPlan(mem_code);
			System.out.println("예정된 여행성공");
			System.out.println(orders);
			model.addAttribute("orders", orders);
			
			porder=oservice.getTravel(mem_code);
			System.out.println("지난여행 성공");
			System.out.println(porder);
			model.addAttribute("porder", porder);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("실패");
		}
		model.addAttribute("content", dir+"mypage");	
		model.addAttribute("mypagecenter",dir+"travel_list");
		return "main";
	}
	
	// 예정된 여행
	@RequestMapping("/travel_plan")
	public String travel_plan(Model model, int mem_code) {	
		List<OrderDTO> orders=null;

		try {
			orders=oservice.getTravelPlan(mem_code);
			System.out.println("성공");
			System.out.println(orders);
			model.addAttribute("orders", orders);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("실패");
		}
		
		model.addAttribute("content", dir+"mypage");	
		model.addAttribute("mypagecenter",dir+"travel_plan");
		return "main";
	}
	
	// 다녀온 여행
	@RequestMapping("/travel_past")
	public String travel_past(Model model, int mem_code) {	
		List<OrderDTO> ord = null;
		List<ReviewDTO> rev=null;
		
		try {
			ord=oservice.getTravelPast(mem_code);
			System.out.println("성공");
			System.out.println(ord);
			model.addAttribute("ord", ord);
			
			rev=rservice.getReviewByMem(mem_code);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("실패");
		}
		List<Integer> code_list=new ArrayList<Integer>();
		for(ReviewDTO review : rev) {
			code_list.add(review.getItem_code());
			}
		System.out.println(rev);
		System.out.println(code_list);
		
		model.addAttribute("code_list", code_list);
		model.addAttribute("rev", rev);
		model.addAttribute("content", dir+"mypage");	
		model.addAttribute("mypagecenter",dir+"travel_past");
		return "main";
	}
	
	
	// 리뷰 등록
		@RequestMapping("/insert")
		public String insert(Model model, ReviewDTO review) {
			
			// 사진 파일 등록
			String file1 = review.getImg().getOriginalFilename();
			review.setReview_img(file1);	
			Util.saveFile(review.getImg(), admindir, custdir+"review/");	// 어드민, 커스트의 review 파일에 저장하겠다
			
			try {
				rservice.register(review);	
				System.out.println("등록 성공");
				model.addAttribute("review", review);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("등록 실패");
			}
			model.addAttribute("content", dir+"mypage");	
			model.addAttribute("mypagecenter",dir+"travel_past");
			return "redirect:travel_past?mem_code="+review.getMem_code();
		}
	
	// 작성한 리뷰 보기
	@RequestMapping("/myreview")					
	public String myreview(Model model, int mem_code) {
		List<ReviewDTO> reviews=null;
		
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
	
	
	// 나의 위시리스트
	@RequestMapping("/mywishlist")
	public String mywishlist(Model model, int mem_code) {	
		List<WishDTO> wishs=null;

		try {
			wishs=wservice.getWishByMem(mem_code);
			System.out.println("성공");
			System.out.println(wishs);
			model.addAttribute("wishs", wishs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("실패");
		}
		model.addAttribute("content", dir+"mypage");	
		model.addAttribute("mypagecenter",dir+"mywishlist");
		return "main";
	}
	

	
}
