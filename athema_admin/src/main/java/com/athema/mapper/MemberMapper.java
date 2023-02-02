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
	public int getTodayMember() throws Exception;
	public int getYesterdayMember() throws Exception;
	public int getWeekMember() throws Exception;
	public int getMonthMember() throws Exception;
	public int getTotMember() throws Exception;
	public int getTodayWithdraw() throws Exception;
	public int getMonthWithdraw() throws Exception;
	public int getTotWithdraw() throws Exception;
}
