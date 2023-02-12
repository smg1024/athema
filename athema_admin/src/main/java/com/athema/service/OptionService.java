package com.athema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athema.dto.OptionDTO;
import com.athema.frame.AthemaService;
import com.athema.mapper.OptionMapper;

@Service
public class OptionService implements AthemaService<Integer, OptionDTO> {
	
	@Autowired
	OptionMapper mapper;

	@Override
	public void register(OptionDTO v) throws Exception {
		mapper.insert(v);
		
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);
		
	}

	@Override
	public void modify(OptionDTO v) throws Exception {
		mapper.update(v);
		
	}

	@Override
	public OptionDTO get(Integer k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<OptionDTO> getall() throws Exception {
		return mapper.selectall();
	}
	
	public List<OptionDTO> getoptions(Integer item_code) throws Exception {
		return mapper.getoptions(item_code);
	}
}
