package com.athema.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.athema.dto.OptionDTO;
import com.athema.frame.AthemaMapper;

@Repository
@Mapper
public interface OptionMapper extends AthemaMapper<Integer, OptionDTO>{
	public int getprice(int item_code, int opt_code, int opt_quantity) throws Exception;
}
