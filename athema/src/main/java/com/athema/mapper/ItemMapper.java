package com.athema.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.athema.dto.ItemDTO;
import com.athema.frame.AthemaMapper;

@Repository
@Mapper
public interface ItemMapper extends AthemaMapper<Integer, ItemDTO>{
	public List<ItemDTO> options(Integer k) throws Exception;
	public ItemDTO dayselect(Integer k) throws Exception;
	public List<ItemDTO> search_theme(Integer k) throws Exception;
	public List<ItemDTO> search_loc(String cate_name) throws Exception;
	public List<ItemDTO> search_item(Integer k, String cate_name) throws Exception;
}
