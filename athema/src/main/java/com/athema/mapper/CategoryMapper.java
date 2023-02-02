package com.athema.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.athema.dto.CategoryDTO;
import com.athema.frame.AthemaMapper;

@Repository
@Mapper
public interface CategoryMapper extends AthemaMapper<Integer, CategoryDTO> {
	public String search_theme_name(Integer k) throws Exception;
}
