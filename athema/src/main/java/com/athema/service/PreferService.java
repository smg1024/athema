package com.athema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athema.dto.PreferDTO;
import com.athema.frame.AthemaService;
import com.athema.mapper.PreferMapper;

@Service
public class PreferService implements AthemaService<Integer, PreferDTO> {
	
	@Autowired
	PreferMapper mapper;

	@Override
	public void register(PreferDTO v) throws Exception {
		mapper.insert(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
	}

	@Override
	public void modify(PreferDTO v) throws Exception {
		mapper.update(v);
	}

	@Override
	public PreferDTO get(Integer k) throws Exception {
		return null;
	}

	@Override
	public List<PreferDTO> getall() throws Exception {
		return mapper.selectall();
	}
	
}
