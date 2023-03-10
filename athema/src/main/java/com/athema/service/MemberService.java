package com.athema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athema.dto.MemberDTO;
import com.athema.frame.AthemaService;
import com.athema.mapper.MemberMapper;

@Service
public class MemberService implements AthemaService<Integer, MemberDTO> {
	
	@Autowired
	MemberMapper mapper;
	
	@Override
	public void register(MemberDTO v) throws Exception {
		mapper.insert(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);
	}

	@Override
	public void modify(MemberDTO v) throws Exception {
		mapper.update(v);
	}

	@Override
	public MemberDTO get(Integer k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<MemberDTO> getall() throws Exception {
		return null;
	}
	
	public void removeall(Integer k) throws Exception {
		mapper.deleteall(k);
	}
	
	public void modifybutpass(MemberDTO v) throws Exception {
		mapper.updatebutpass(v);
	}
	
	public int getemail(String email) throws Exception {
		return mapper.selectemail(email);
	}
	
	public MemberDTO searchemail(String email) throws Exception {
		return mapper.searchemail(email);
	}
	
	public void modifykakao(MemberDTO v) throws Exception {
		mapper.updatekakao(v);
	}
}
