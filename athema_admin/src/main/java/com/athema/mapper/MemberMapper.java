package com.athema.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.athema.dto.MemberDTO;
import com.athema.frame.AthemaMapper;

@Repository
@Mapper
public interface MemberMapper extends AthemaMapper<Integer, MemberDTO>{
	public void delchange(Integer k) throws Exception;
	public MemberDTO searchemail(String email) throws Exception; 
	public void updateAuth(MemberDTO member) throws Exception;
}
