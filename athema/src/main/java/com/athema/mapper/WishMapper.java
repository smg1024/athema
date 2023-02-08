package com.athema.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.athema.dto.WishDTO;
import com.athema.frame.AthemaMapper;

@Repository
@Mapper

public interface WishMapper extends AthemaMapper<Integer, WishDTO>{
	public int wishlist(Integer mem_code, Integer item_code) throws Exception;
	public void del_wishlist(Integer item_code, Integer mem_code) throws Exception;
}
