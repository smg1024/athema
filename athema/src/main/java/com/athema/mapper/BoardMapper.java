package com.athema.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.athema.dto.BoardDTO;
import com.athema.frame.AthemaMapper;

@Repository
@Mapper
public interface BoardMapper extends AthemaMapper<Integer, BoardDTO>{
}
