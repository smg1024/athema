package com.athema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athema.frame.AthemaService;
import com.athema.dto.ReviewDTO;
import com.athema.mapper.ReviewMapper;


@Service
public class ReviewService implements AthemaService<Integer, ReviewDTO>{
	
	@Autowired
	ReviewMapper mapper;

	@Override
	public void register(ReviewDTO v) throws Exception {
		mapper.insert(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);
	}

	@Override
	public void modify(ReviewDTO v) throws Exception {
		mapper.update(v);
	}

	@Override
	public ReviewDTO get(Integer k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<ReviewDTO> getall() throws Exception{
		return mapper.selectall();
	}
	
	public Double avg_rating(Integer k) throws Exception {
		return mapper.avg_rating(k);
	}
	
	// 특정 회원 리뷰 보기
	public List<ReviewDTO> getReviewByMem(int mem_code) throws Exception {
		return mapper.getReviewByMem(mem_code);
	}
	
	// 특정 아이템 리뷰 보기
	public List<ReviewDTO> getReviewByItem(int item_code) throws Exception {
		return mapper.getReviewByItem(item_code);
	}
	
	// 
	public List<ReviewDTO> getReview(int mem_code) throws Exception {
		return mapper.getReview(mem_code);
	}
}
