package com.athema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athema.dto.BoardDTO;
import com.athema.frame.AthemaService;
import com.athema.mapper.BoardMapper;


@Service
public class BoardService implements AthemaService<Integer, BoardDTO>{
	
	@Autowired
	BoardMapper mapper;

	@Override
	public void register(BoardDTO v) throws Exception {
		mapper.insert(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);
	}

	@Override
	public void modify(BoardDTO v) throws Exception {
		mapper.update(v);
	}

	@Override
	public BoardDTO get(Integer k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<BoardDTO> getall() throws Exception {
		return mapper.selectall();
	}
	
	public int getboard_code(BoardDTO v) throws Exception {
		return mapper.getboard_code(v);
	}
	
	public List<BoardDTO> getcomments(Integer k) throws Exception {
		return mapper.getcomments(k);
	}
	
	public void comment(BoardDTO v) throws Exception {
		mapper.comment(v);
	}
	
	public void removeComment(Integer k) throws Exception {
		mapper.delcomment(k);
	}
}
