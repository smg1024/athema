package com.athema.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.athema.dto.BoardDTO;
import com.athema.frame.AthemaMapper;

@Repository
@Mapper
public interface BoardMapper extends AthemaMapper<Integer, BoardDTO>{
	public int getboard_code(BoardDTO v) throws Exception;
	public List<BoardDTO> getcomments(Integer k) throws Exception;
	public void comment(BoardDTO v) throws Exception;
	public void delcomment(Integer k) throws Exception;
}
