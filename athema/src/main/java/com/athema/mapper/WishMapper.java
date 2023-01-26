package com.athema.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.athema.dto.WishDTO;
import com.athema.frame.AthemaMapper;

@Repository
@Mapper

public interface WishMapper extends AthemaMapper<Integer, WishDTO>{

}
