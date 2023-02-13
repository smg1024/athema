package com.athema.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.athema.dto.ItemDTO;
import com.athema.service.CategoryService;
import com.athema.service.ItemService;
import com.athema.service.ReviewService;

@Controller
public class OffersController {
	@Autowired
	ItemService iservice;
	
	@Autowired
	CategoryService cservice;
	
	@Autowired
	ReviewService rservice;
	
	@RequestMapping("/search")
	public String search(Model model, @RequestParam List<Integer> theme_codes, @RequestParam List<String> loc_names) {
		List<ItemDTO> list = new ArrayList<ItemDTO>();
		List<String> theme_names = new ArrayList<String>();
		
		try {
			if(!theme_codes.isEmpty()) {
				for(int up_cate_code : theme_codes) {
					if(loc_names.isEmpty()) {
						List<ItemDTO> temp = null;
						temp = iservice.search_theme(up_cate_code);
						for(ItemDTO item : temp) {
							item.setItem_price(iservice.min_price(item.getItem_code()));
//							Double avg_rating = rservice.avg_rating(item.getItem_code());
//							if(!avg_rating.equals(null)) item.setAvg_rating(rservice.avg_rating(item.getItem_code()));
							list.add(item);
						}
					}else {
						for(String cate_name : loc_names) {
							List<ItemDTO> temp = null;
							temp = iservice.search_item(up_cate_code, cate_name);
							for(ItemDTO item : temp) {
								item.setItem_price(iservice.min_price(item.getItem_code()));
//								Double avg_rating = rservice.avg_rating(item.getItem_code());
//								if(!avg_rating.equals(null)) item.setAvg_rating(rservice.avg_rating(item.getItem_code()));
								list.add(item);
							}
						}
					}
					theme_names.add(cservice.search_theme_name(up_cate_code));
				}
			}else {
				if(!loc_names.isEmpty()) {
					for(String cate_name : loc_names) {
						List<ItemDTO> temp = null;
						temp = iservice.search_loc(cate_name);
						for(ItemDTO item : temp) {
							item.setItem_price(iservice.min_price(item.getItem_code()));
//							Double avg_rating = rservice.avg_rating(item.getItem_code());
//							if(!avg_rating.equals(null)) item.setAvg_rating(rservice.avg_rating(item.getItem_code()));
							list.add(item);
						}
					}
				}else {
					list = iservice.getall();
					for(ItemDTO item : list) {
						item.setItem_price(iservice.min_price(item.getItem_code()));
//						Double avg_rating = rservice.avg_rating(item.getItem_code());
//						if(!avg_rating.equals(null)) item.setAvg_rating(rservice.avg_rating(item.getItem_code()));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		System.out.println(theme_codes);
//		System.out.println(loc_names);
//		System.out.println(theme_names);
//		System.out.println(list);
		
		model.addAttribute("loc_names", loc_names);
		model.addAttribute("theme_names", theme_names);
		model.addAttribute("itemlist", list);
		model.addAttribute("content", "offers");
		return "main";
	}
	
	// 사용 X
	@RequestMapping("/search_theme")
	public String search_theme(Model model, @RequestParam List<Integer> theme_codes) {
		List<ItemDTO> list = new ArrayList<ItemDTO>();
		List<String> theme_names = new ArrayList<String>();
		
		try {
			for(int up_cate_code : theme_codes) {
				List<ItemDTO> temp = null;
				temp = iservice.search_theme(up_cate_code);
				for(ItemDTO item : temp) {
					list.add(item);
				}
				theme_names.add(cservice.search_theme_name(up_cate_code));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
//		System.out.println(theme_names);
		model.addAttribute("theme_names", theme_names);
		model.addAttribute("itemlist", list);
		model.addAttribute("content", "offers");
		return "main";
	}
	
	// 사용 X
	@RequestMapping("/search_loc")
	public String search_loc(Model model, @RequestParam List<String> loc_names) {
		List<ItemDTO> list = new ArrayList<ItemDTO>();
		
		try {
			for(String cate_name : loc_names) {
				List<ItemDTO> temp = null;
				temp = iservice.search_loc(cate_name);
				for(ItemDTO item : temp) {
					list.add(item);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("loc_names", loc_names);
		model.addAttribute("itemlist", list);
		model.addAttribute("content", "offers");
		return "main";
	}
}
