package com.athema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athema.dto.OrderDTO;
import com.athema.frame.AthemaService;
import com.athema.mapper.OrderMapper;

@Service
public class OrderService implements AthemaService<Integer, OrderDTO>{

	@Autowired
	OrderMapper mapper;

	@Override
	public void register(OrderDTO v) throws Exception {
		mapper.insert(v);
		
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);
		
	}

	@Override
	public void modify(OrderDTO v) throws Exception {
		mapper.update(v);
		
	}

	@Override
	public OrderDTO get(Integer k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<OrderDTO> getall() throws Exception {
		return mapper.selectall();
	}
	
	
	/*
	 * public void totprice(OrderDTO v) throws Exception{ mapper.totprice(v); }
	 */
}
