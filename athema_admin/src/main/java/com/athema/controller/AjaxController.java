package com.athema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.athema.dto.MemberDTO;
import com.athema.dto.OrderDTO;
import com.athema.service.MemberService;
import com.athema.service.OrderService;

@RestController
public class AjaxController {
	
	@Autowired
	MemberService mservice;
	
	@Autowired
	OrderService oservice;
	
	// 관리자 <-> 일반 회원 수정
	@RequestMapping("/updateAuth")
	public void updateAuth(MemberDTO member, int mem_code, char mem_auth) {
		System.out.println("##"+mem_code +"&"+ mem_auth);
		try {
		if (mem_auth == 'M') {
			member.setMem_auth('A');
			mservice.modifyAuth(member);
			}
		if (mem_auth == 'A') {
			member.setMem_auth('M');
			mservice.modifyAuth(member);
		}
		} catch (Exception e) {
			System.out.println("수정 실패");
			e.printStackTrace();
		}
	}

	// 일반 탈퇴처리
	@RequestMapping("/delchange")
	public void delchange(int mem_code, int mem_del) {
//		System.out.println("##"+mem_code);
		try {
			if (mem_del != 1) {
				mservice.delchange(mem_code);
			}
			if (mem_del == 1) {
				mservice.delchange(mem_code);
			}
		} catch (Exception e) {
			System.out.println("탈퇴코드 수정 실패");
			e.printStackTrace();
		}
	}
	
	// 영구 탈퇴처리
	@RequestMapping("/del")
	public void del(int mem_code) {
		System.out.println("##"+mem_code);
		try {
			mservice.remove(mem_code);
			System.out.println("레코드 삭제 완료");
		} catch (Exception e) {
			System.out.println("삭제 실패");
			e.printStackTrace();
		}
	}
	
	// 사용 여부 0<->1
		@RequestMapping("/updateused")
		public void updateAuth(OrderDTO order, int detail_code, int used) {
			try {
			if (used == 0) {
				order.setUsed(1);
				oservice.updateused(order);
				}
			if (used == 1) {
				order.setUsed(0);
				oservice.updateused(order);
			}
			} catch (Exception e) {
				System.out.println("수정 실패");
				e.printStackTrace();
			}
		}
		
}
