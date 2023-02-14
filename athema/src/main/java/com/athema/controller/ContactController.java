package com.athema.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.athema.dto.BoardDTO;
import com.athema.dto.MemberDTO;
import com.athema.frame.Util;
import com.athema.service.BoardService;
import com.athema.service.MemberService;

@Controller
public class ContactController {
	String dir = "/contact";
	
	@Value("${admindir}")
	String admindir;
	
	@Value("${custdir}")
	String custdir;
	
	@Autowired
	BoardService bservice;
	
	@Autowired
	MemberService mservice;
	
	@RequestMapping("/board_post")
	public String board_post(Model model, HttpSession session) {
		
		if(session.getAttribute("loginMember")==null) {
			model.addAttribute("content", "login");
		}else {
			model.addAttribute("content", "boardpost");
		}
		
		return "main";
	}
	
	@RequestMapping("/board_post_impl")
	public String board_post_impl(Model model, BoardDTO board, HttpSession session) {
		MemberDTO member = (MemberDTO) session.getAttribute("loginMember");
		int mem_code = member.getMem_code();
		
		board.setMem_code(mem_code);
		
		
		int new_board_code = 0;
		
		try {
			if(!board.getFile1().isEmpty()) {
				String file1 = board.getFile1().getOriginalFilename();
				board.setBoard_filename1(file1);
				Util.saveFile(board.getFile1(), admindir, custdir+"board/");
			}
			if(!board.getFile2().isEmpty()) {
				String file2 = board.getFile2().getOriginalFilename();
				board.setBoard_filename2(file2);
				Util.saveFile(board.getFile2(), admindir, custdir+"board/");
			}
			System.out.println(board);
			bservice.register(board);
			new_board_code = bservice.getboard_code(board);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:boardview?board_code="+new_board_code;
	}
	
	@RequestMapping("/board_edit")
	public String board_edit(Model model, Integer board_code) {
		BoardDTO board = null;
		
		try {
			board = bservice.get(board_code);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("board", board);
		model.addAttribute("content", "boardedit");
		return "main";
	}
	
	@RequestMapping("/board_edit_impl")
	public String board_edit_impl(Model model, BoardDTO board) {
		System.out.println(board);
		int new_board_code = board.getBoard_code();
		
		try {
			bservice.modify(board);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:boardview?board_code="+new_board_code;
	}
	
	@RequestMapping("/board_del_impl")
	public String board_del_impl(Model model, Integer board_code) {
		try {
			bservice.remove(board_code);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:contact";
	}
	
	@RequestMapping("/comment_del_impl")
	public String board_del_impl(HttpServletRequest request, Model model, Integer board_code) {
		
		try {
			bservice.remove(board_code);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String referer = request.getHeader("Referer");
		return "redirect:"+referer;
	}
	
	@RequestMapping("/boardview")
	public String boardview(Model model, Integer board_code) {
		BoardDTO board = null;
		MemberDTO author = null;
		List<BoardDTO> comments = null;
		
		try {
			board = bservice.get(board_code);
			author = mservice.get(board.getMem_code());
			comments = bservice.getcomments(board_code);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("comments", comments);
		model.addAttribute("author", author);
		model.addAttribute("board", board);
		model.addAttribute("content", "boardview");
		return "main";
	}
	
	@RequestMapping("/comment_impl")
	public String comment_impl(Model model, BoardDTO board) {
		System.out.println(board);
		
		int new_board_code = board.getUp_board_code();
		
		try {
			bservice.comment(board);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:boardview?board_code="+new_board_code;
	}
}
