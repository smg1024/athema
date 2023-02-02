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
		return mapper.selectall();
	}
	
	public void delchange(Integer k) throws Exception {
		mapper.delchange(k);
	}
	
	public MemberDTO searchemail(String email) throws Exception{
		return mapper.searchemail(email);
	};
	
	public void modifyAuth(MemberDTO v) throws Exception {
		mapper.updateAuth(v);
	}
	
	public int getTodayMember() throws Exception {
		return mapper.getTodayMember();
	}

	public int getWeekMember() throws Exception {
		return mapper.getWeekMember();
	}
	
	public int getMonthMember() throws Exception {
		return mapper.getMonthMember();
	}
	
	public int getTotMember() throws Exception {
		return mapper.getTotMember();
	}
	
}
