package com.athema.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.athema.dto.BoardDTO;
import com.athema.dto.ItemDTO;
import com.athema.dto.MemberDTO;
import com.athema.dto.ReviewDTO;
import com.athema.service.BoardService;
import com.athema.service.ItemService;
import com.athema.service.MemberService;
import com.athema.service.ReviewService;
import com.athema.service.WishService;

@Controller
public class MainController {
	
	@Autowired
	ItemService iservice;
	
	@Autowired
	ReviewService rservice;
	
	@Autowired
	MemberService mservice;
	
	@Autowired
	WishService wservice;
	
	@Autowired
	BoardService bservice;
	
	@RequestMapping("")
	public String main(Model model) {
		model.addAttribute("content", "index");
		return "main";
	}
	
	@RequestMapping("/main")
	public String main2(Model model) {
		model.addAttribute("content", "index");
		return "main";
	}

	@RequestMapping("/index")
	public String index(Model model) {
		model.addAttribute("content", "index");
		return "main";
	}
	
	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("content", "login");
		return "main";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session, Model model) {
		if(session != null) {
			session.invalidate();		// 세션 값 삭제
		}
		model.addAttribute("content", "index");		// 메인으로 돌아감
		return "main";
	}
	
	@RequestMapping("/register")
	public String register(Model model) {
		model.addAttribute("content", "register");
		return "main";
	}
	
	@RequestMapping("/about")
	public String about(Model model) {
		model.addAttribute("content", "about");
		return "main";
	}
	
	@RequestMapping("/offers")
	public String offers(Model model) {
		List<ItemDTO> list = null;
		
		try {
			list = iservice.getall();
			for(ItemDTO item : list) {
				item.setItem_price(iservice.min_price(item.getItem_code()));
				if(rservice.avg_rating(item.getItem_code())!=null) item.setAvg_rating(rservice.avg_rating(item.getItem_code()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("itemlist", list);
		model.addAttribute("content", "offers");
		return "main";
	}
	
	@RequestMapping("/blog")
	public String blog(Model model) {
		model.addAttribute("content", "blog");
		return "main";
	}
	
	@RequestMapping("/contact")
	public String contact(Model model) {
		List<BoardDTO> boardlist = null;
		
		try {
			boardlist = bservice.getall();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("boardlist", boardlist);
		model.addAttribute("content", "contact");
		return "main";
	}
	
	@RequestMapping("/elements")
	public String elements(Model model) {
		model.addAttribute("content", "elements");
		return "main";
	}

	@RequestMapping("/single_listing")
	public String single_listing(HttpSession session, Model model, int item_code) {
		ItemDTO item = null;
		List<ItemDTO> options = null;
		int wishlist = 0;
		int mem_code = 0;
		
		List<ReviewDTO> reviews=null;
		MemberDTO mem=null;
		
		try {
			item = iservice.get(item_code);
			options = iservice.options(item_code);
			item.setAvg_rating(rservice.avg_rating(item_code));
			
			reviews=rservice.getReviewByItem(item_code);
			System.out.println("리뷰 불러오기 성공");
			System.out.println(reviews);
			model.addAttribute("reviews", reviews);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(session.getAttribute("loginMember") != null) {
			MemberDTO member = (MemberDTO) session.getAttribute("loginMember");
			mem_code = member.getMem_code();
			try {
				wishlist = wservice.wishlist(mem_code, item.getItem_code());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		model.addAttribute("mem_code", mem_code);
		model.addAttribute("wishlist", wishlist);
		model.addAttribute("item", item);
		model.addAttribute("options", options);
		model.addAttribute("content", "single_listing");
		return "main";
	}
	
	
	@RequestMapping("/order")
	public String order(Model model, Integer mem_code, Integer item_code, 
			@RequestParam (value ="opt_codes", required=false) List<Integer> opt_codes, 
			@RequestParam (value="opt_quantities",required=false) List<Integer> opt_quantities) {
		
		
		if(mem_code==null){ 
			return "redirect:login";
		 
		 }else {
		 
			ItemDTO item = null;
			ItemDTO day = null;
			List<ItemDTO> options = null;
			MemberDTO member = null;
			
			try {
				item = iservice.get(item_code);
				options = iservice.options(item_code);
				day = iservice.dayselect(item_code);
				member = mservice.get(mem_code);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			model.addAttribute("member", member);
			model.addAttribute("item", item);
			model.addAttribute("olist", options);
			model.addAttribute("day", day);
			model.addAttribute("content", "order");
			model.addAttribute("cnt",opt_quantities);
		 }
		System.out.println("회원코드:"+mem_code);
		System.out.println("아이템코드:"+item_code);
		System.out.println("옵션코드:"+opt_codes);
		System.out.println("옵션수량:"+opt_quantities);
		return "main";
	}
	
	@RequestMapping("/order_detail")
	public String order_detail(Model model) {
		model.addAttribute("content", "order_detail");
		return "main";
	}

	@RequestMapping("/qnachat")
	public String qnachat(Model model, HttpSession session) {
		if(session.getAttribute("loginMember") == null) {		// 로그인 이용자만 1:1 채팅 가능
			model.addAttribute("content", "login");
		} else {
			model.addAttribute("content", "qnachat");
		}
		return "main";
	}

	@RequestMapping("/preferselect")
	public String preferselect(Model model) {
		model.addAttribute("content", "preferselect");
		return "main";
	}
	
	@RequestMapping("/wish")
	public String wish(Model model) {
		model.addAttribute("content", "wish");
		return "main";
	}
	
}
