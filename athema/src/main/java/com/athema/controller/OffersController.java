package com.athema.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.athema.dto.ItemDTO;
import com.athema.service.ItemService;

@Controller
public class OffersController {
	@Autowired
	ItemService iservice;
	
	@RequestMapping("/search_theme")
	public String search_theme(Model model, @RequestParam List<Integer> theme_codes) {
		List<ItemDTO> list = new ArrayList<ItemDTO>();
		
		try {
			for(int up_cate_code : theme_codes) {
				List<ItemDTO> temp = null;
				temp = iservice.search_theme(up_cate_code);
				for(ItemDTO item : temp) {
					list.add(item);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("itemlist", list);
		model.addAttribute("content", "offers");
		return "main";
	}
	
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
		
		model.addAttribute("itemlist", list);
		model.addAttribute("content", "offers");
		return "main";
	}
}
