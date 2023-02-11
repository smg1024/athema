package com.athema.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.athema.dto.OrderDTO;
import com.athema.dto.ReviewDTO;
import com.athema.frame.AthemaMapper;

@Repository
@Mapper
public interface OrderMapper extends AthemaMapper<Integer, OrderDTO>{
	/* public void totprice(OrderDTO v) throws Exception; */
	
	public List<OrderDTO> getTravelPlan(int mem_code);
	
	public List<OrderDTO> getTravelPast(int mem_code);
}
