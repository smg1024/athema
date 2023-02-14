package com.athema.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.athema.dto.ReviewDTO;
import com.athema.frame.AthemaMapper;

@Repository
@Mapper
public interface ReviewMapper extends AthemaMapper<Integer, ReviewDTO>{
	public Double avg_rating(Integer k) throws Exception;
	
	public List<ReviewDTO> getReviewByMem(int mem_code);
	
	public List<ReviewDTO> getReviewByItem(int item_code);
	
	public List<ReviewDTO> getReview(int mem_code);
}
