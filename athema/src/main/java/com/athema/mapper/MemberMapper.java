package com.athema.mapper;

import org.springframework.stereotype.Repository;

import com.athema.dto.MemberDTO;
import com.athema.frame.AthemaMapper;

@Repository
//@Mapper (아직 mybatis open 안 해서 어노테이션 불가)
public interface MemberMapper extends AthemaMapper<Integer, MemberDTO> {
	public void delete(MemberDTO member) throws Exception;
}
