package com.athema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athema.dto.ItemDTO;
import com.athema.frame.AthemaService;
import com.athema.mapper.ItemMapper;

@Service
public class ItemService implements AthemaService<Integer, ItemDTO> {

	@Autowired
	ItemMapper mapper;
	
	@Override
	public void register(ItemDTO v) throws Exception {
		mapper.insert(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);
	}

	@Override
	public void modify(ItemDTO v) throws Exception {
		mapper.update(v);
	}

	@Override
	public ItemDTO get(Integer k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<ItemDTO> getall() throws Exception {
		return mapper.selectall();
	}

}
