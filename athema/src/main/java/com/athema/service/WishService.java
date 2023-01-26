package com.athema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athema.frame.AthemaService;
import com.athema.dto.WishDTO;
import com.athema.mapper.WishMapper;

@Service
public class WishService implements AthemaService<Integer, WishDTO> {
	
	@Autowired
	WishMapper mapper;

	@Override
	public void register(WishDTO v) throws Exception {
		mapper.insert(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);
	}

	@Override
	public void modify(WishDTO v) throws Exception {
		mapper.update(v);
	}

	@Override
	public WishDTO get(Integer k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<WishDTO> getall() throws Exception {
		return mapper.selectall();
	}
	
	
}
