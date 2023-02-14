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
	
	public List<OrderDTO> getTravelPlan(int mem_code);
	
	public List<OrderDTO> getTravelPast(int mem_code);
	
	public List<OrderDTO> getTravel(int mem_code);
	
	//ord_detail에 넣을 order_code
	public OrderDTO onum(Integer k) throws Exception;

	
}
