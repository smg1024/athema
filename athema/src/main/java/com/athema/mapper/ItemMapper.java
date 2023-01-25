package com.athema.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.athema.dto.ItemDTO;
import com.athema.frame.AthemaMapper;

@Repository
@Mapper
public interface ItemMapper extends AthemaMapper<Integer, ItemDTO>{
	

}
