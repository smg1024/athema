package com.athema.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.athema.dto.OrderDTO;
import com.athema.frame.AthemaMapper;

@Repository
@Mapper
public interface OrderMapper extends AthemaMapper<Integer, OrderDTO>{
	/* public void totprice(OrderDTO v) throws Exception; */
}
