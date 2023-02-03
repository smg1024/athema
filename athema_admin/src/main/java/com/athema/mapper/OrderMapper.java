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
}
