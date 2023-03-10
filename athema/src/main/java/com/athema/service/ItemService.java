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
	
	public List<ItemDTO> options(Integer k) throws Exception {
		return mapper.options(k);
	}
	
	public ItemDTO dayselect(Integer k) throws Exception {
		return mapper.dayselect(k);
	}
	
	public List<ItemDTO> search_theme(Integer k) throws Exception{
		return mapper.search_theme(k);
	}
	
	public List<ItemDTO> search_loc(String cate_name) throws Exception {
		return mapper.search_loc(cate_name);
	}
	
	public List<ItemDTO> search_item(Integer k, String cate_name) throws Exception {
		return mapper.search_item(k, cate_name);
	}
	
	public int min_price(Integer k) throws Exception{
		return mapper.min_price(k);
	}

}
