package com.athema.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.athema.dto.OrdDetailDTO;
import com.athema.frame.AthemaMapper;

@Repository
@Mapper
public interface OrdDetailMapper extends AthemaMapper<Integer, OrdDetailDTO>{

}