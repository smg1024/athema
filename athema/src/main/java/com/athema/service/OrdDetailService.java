package com.athema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athema.dto.OrdDetailDTO;
import com.athema.frame.AthemaService;
import com.athema.mapper.OrdDetailMapper;

@Service
public class OrdDetailService implements AthemaService<Integer, OrdDetailDTO> {
	
	@Autowired
	OrdDetailMapper mapper;

	@Override
	public void register(OrdDetailDTO v) throws Exception {
		mapper.insert(v);
		
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);
		
	}

	@Override
	public void modify(OrdDetailDTO v) throws Exception {
		mapper.update(v);
		
	}

	@Override
	public OrdDetailDTO get(Integer k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<OrdDetailDTO> getall() throws Exception {
		return mapper.selectall();
	}
	
}
