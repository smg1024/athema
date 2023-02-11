package com.athema.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.athema.dto.OrderDTO;
import com.athema.frame.AthemaMapper;

@Repository
@Mapper
public interface OrderMapper extends AthemaMapper<Integer, OrderDTO>{
	public List<OrderDTO> listall() throws Exception;
	public void updateused(OrderDTO order) throws Exception;
	public void deletecode(Integer k) throws Exception;
	
	// 주문건수, 매출
	public int getMonthOrder() throws Exception;
	public int getDayOrder() throws Exception;
	public int getYearSales() throws Exception;
	public int getMonthSales() throws Exception;
	public int getDaySales() throws Exception;
}
