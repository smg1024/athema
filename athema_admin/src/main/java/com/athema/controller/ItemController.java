package com.athema.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.athema.dto.ItemDTO;
import com.athema.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {
	String dir = "/item/";
	
	@Autowired
	ItemService iservice;
	
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
	public String addimpl(Model model, ItemDTO item) {
		try {
			iservice.register(item);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:getall";
	}
	
	@RequestMapping("/edit")
	public String edit(Model model, int item_code) {
		ItemDTO item = null;
		
		try {
			item = iservice.get(item_code);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("item", item);
		model.addAttribute("center", dir+"edit");
		return "main";
	}
	
	@RequestMapping("/editimpl")
	public String editimpl(Model model, ItemDTO item) {
		try {
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
