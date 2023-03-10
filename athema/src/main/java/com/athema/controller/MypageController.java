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
		model.addAttribute("mypageleft",dir+ "mypageleft");
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
		model.addAttribute("mypageleft",dir+ "userpageleft");
		model.addAttribute("mypagecenter",dir+"userpage");
		return "main";
	}
	@RequestMapping("/update")
	public String update(Model model, MemberDTO member) {
		String mem_pwd = member.getMem_pwd();
		System.out.println("??????"+mem_pwd);
		
		if(mem_pwd.equals("") || mem_pwd == null) {
			try {
				mservice.modifybutpass(member);
				System.out.println("??????x ????????????");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("??????x ????????????");
				e.printStackTrace();
			}
		}else {
			try {
				mservice.modify(member);
				System.out.println("????????? ????????????");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("????????? ????????????");
				e.printStackTrace();
			}
		}
		System.out.println("????????? ???"+member);
		model.addAttribute("obj",member);
		model.addAttribute("content", dir+"mypage");
		model.addAttribute("mypageleft",dir+ "userpageleft");
		model.addAttribute("mypagecenter",dir+"userpage");
		return "redirect:userpage?mem_email="+member.getMem_email();
	}
	
	 @RequestMapping("/delete")
	 public String delete(Model model, int mem_code) {
		 try { 
			 mservice.remove(mem_code);
			 System.out.println("??????");
		 } catch (Exception e) { 
			 // TODO Auto-generated catch block
			 e.printStackTrace(); 
			 System.out.println("??????x");
		 } 
	 return "redirect:/logout";
	 }
	 
	// ?????? ??????
	@RequestMapping("/travel_list")
	public String travel_list(Model model, int mem_code) {	
		List<OrderDTO> orders=null;
		List<OrderDTO> porder = null;
		
		try {
			orders=oservice.getTravelPlan(mem_code);
			System.out.println("????????? ????????????");
			System.out.println(orders);
			model.addAttribute("orders", orders);
			
			porder=oservice.getTravel(mem_code);
			System.out.println("???????????? ??????");
			System.out.println(porder);
			model.addAttribute("porder", porder);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("??????");
		}
		model.addAttribute("content", dir+"mypage");
		model.addAttribute("mypageleft",dir+ "travelleft");
		model.addAttribute("mypagecenter",dir+"travel_list");
		return "main";
	}
	
	// ????????? ??????
	@RequestMapping("/travel_plan")
	public String travel_plan(Model model, int mem_code) {	
		List<OrderDTO> orders=null;

		try {
			orders=oservice.getTravelPlan(mem_code);
			System.out.println("??????");
			System.out.println(orders);
			model.addAttribute("orders", orders);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("??????");
		}
		
		model.addAttribute("content", dir+"mypage");
		model.addAttribute("mypageleft",dir+ "tplanleft");
		model.addAttribute("mypagecenter",dir+"travel_plan");
		return "main";
	}
	
	// ????????? ??????
	@RequestMapping("/travel_past")
	public String travel_past(Model model, int mem_code) {	
		List<OrderDTO> ord = null;
		List<ReviewDTO> rev=null;
		
		try {
			ord=oservice.getTravelPast(mem_code);
			System.out.println("??????");
			System.out.println(ord);
			model.addAttribute("ord", ord);
			
			rev=rservice.getReviewByMem(mem_code);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("??????");
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
		model.addAttribute("mypageleft",dir+ "tpastleft");
		model.addAttribute("mypagecenter",dir+"travel_past");
		return "main";
	}
	
	
	// ?????? ??????
		@RequestMapping("/insert")
		public String insert(Model model, ReviewDTO review) {
			
			// ?????? ?????? ??????
			String file1 = review.getImg().getOriginalFilename();
			review.setReview_img(file1);	
			Util.saveFile(review.getImg(), admindir, custdir+"review/");	// ?????????, ???????????? review ????????? ???????????????
			
			try {
				rservice.register(review);	
				System.out.println("?????? ??????");
				model.addAttribute("review", review);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("?????? ??????");
			}
			model.addAttribute("content", dir+"mypage");
			model.addAttribute("mypageleft",dir+ "tpastleft");
			model.addAttribute("mypagecenter",dir+"travel_past");
			return "redirect:travel_past?mem_code="+review.getMem_code();
		}
	
	// ????????? ?????? ??????
	@RequestMapping("/myreview")					
	public String myreview(Model model, int mem_code) {
		List<ReviewDTO> reviews=null;
		
		try {
			reviews=rservice.getReviewByMem(mem_code);
			System.out.println("??????");
			System.out.println(reviews);
			model.addAttribute("reviews", reviews);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("??????");
		}
		
		model.addAttribute("content", dir+"mypage");
		model.addAttribute("mypageleft",dir+ "reviewpageleft");
		model.addAttribute("mypagecenter",dir+"myreview");
		
		return "main";
	}
	
	
	// ?????? ???????????????
	@RequestMapping("/mywishlist")
	public String mywishlist(Model model, int mem_code) {	
		List<WishDTO> wishs=null;

		try {
			wishs=wservice.getWishByMem(mem_code);
			System.out.println("??????");
			System.out.println(wishs);
			model.addAttribute("wishs", wishs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("??????");
		}
		model.addAttribute("content", dir+"mypage");
		model.addAttribute("mypageleft",dir+ "wishleft");
		model.addAttribute("mypagecenter",dir+"mywishlist");
		return "main";
	}
	

	
}
