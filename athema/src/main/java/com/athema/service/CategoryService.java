package com.athema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athema.dto.CategoryDTO;
import com.athema.frame.AthemaService;
import com.athema.mapper.CategoryMapper;

@Service
public class CategoryService implements AthemaService<Integer, CategoryDTO> {
	
	@Autowired
	CategoryMapper mapper;

	@Override
	public void register(CategoryDTO v) throws Exception {
		mapper.insert(v);
		
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);
		
	}

	@Override
	public void modify(CategoryDTO v) throws Exception {
		mapper.update(v);
		
	}

	@Override
	public CategoryDTO get(Integer k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<CategoryDTO> getall() throws Exception {
		return mapper.selectall();
	}
}
