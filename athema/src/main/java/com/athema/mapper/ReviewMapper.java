package com.athema.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.athema.dto.ReviewDTO;
import com.athema.frame.AthemaMapper;

@Repository
@Mapper
public interface ReviewMapper extends AthemaMapper<Integer, ReviewDTO>{

}
