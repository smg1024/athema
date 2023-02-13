package com.athema.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.athema.dto.ItemDTO;
import com.athema.dto.OptionDTO;
import com.athema.frame.Util;
import com.athema.service.ItemService;
import com.athema.service.OptionService;

@Controller
@RequestMapping("/item")
public class ItemController {
	String dir = "/item/";
	
	@Value("${admindir}")
	String admindir;
	
	@Value("${custdir}")
	String custdir;
	
	@Autowired
	ItemService iservice;
	
	@Autowired
	OptionService oservice;
	
	@RequestMapping("/getall")
	public String getall(Model model, HttpSession session){
		if(session.getAttribute("loginAdmin").equals(null)) {
			return "login";
		}
		List<ItemDTO> list = null;
		
		try {
			list = iservice.getall();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("list", list);
		model.addAttribute("center", dir+"getall");
		return "main";
	}
	
	@RequestMapping("/add")
	public String add(Model model, HttpSession session) {
		if(session.getAttribute("loginAdmin").equals(null)) {
			return "login";
		}
		model.addAttribute("center", dir+"add");
		return "main";
	}
	
	@RequestMapping("/addimpl")
	public String addimpl(Model model, ItemDTO item, 
			@RequestParam List<String> opt_names, @RequestParam List<Integer> item_prices) {
		System.out.println(item);
		System.out.println(opt_names);
		System.out.println(item_prices);
		
		String itemimg1 = item.getImg1().getOriginalFilename();
		String itemimg2 = item.getImg2().getOriginalFilename();
		item.setItem_img1(itemimg1);
		item.setItem_img2(itemimg2);
		System.out.println(item);
		try {
			Util.saveFile(item.getImg1(), admindir, custdir+"item/");
			Util.saveFile(item.getImg2(), admindir, custdir+"item/");
			iservice.register(item);
			int item_code = iservice.getitem_code(item.getItem_name());
			for(int i=0; i<opt_names.size(); i++) {
				OptionDTO option = new OptionDTO();
				option.setOpt_name(opt_names.get(i));
				option.setItem_price(item_prices.get(i));
				option.setItem_code(item_code);
				System.out.println(option);
				oservice.register(option);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:getall";
	}
	
	@RequestMapping("/edit")
	public String edit(Model model, int item_code) {
		ItemDTO item = null;
		List<OptionDTO> options = null;
		String theme = null;
		String location = null;
		
		try {
			item = iservice.get(item_code);
			options = oservice.getoptions(item_code);
			theme = iservice.theme(item_code);
			location = iservice.location(item_code);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("theme", theme);
		model.addAttribute("location", location);
		model.addAttribute("options", options);
		model.addAttribute("item", item);
		model.addAttribute("center", dir+"edit");
		return "main";
	}
	
	@RequestMapping("/editimpl")
	public String editimpl(Model model, ItemDTO item) {
		try {
			if(!item.getImg1().isEmpty()) {
				String itemimg1 = item.getImg1().getOriginalFilename();
				item.setItem_img1(itemimg1);
				Util.saveFile(item.getImg1(), admindir, custdir+"/item");
			}
			if(!item.getImg2().isEmpty()) {
				String itemimg2 = item.getImg2().getOriginalFilename();
				item.setItem_img2(itemimg2);
				Util.saveFile(item.getImg2(), admindir, custdir+"/item");
			}
		
			iservice.modify(item);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:getall";
	}
	
	@RequestMapping("/delete")
	public String delete(Model model, int item_code) {
		
		try {
			iservice.remove(item_code);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:getall";
	}
}
