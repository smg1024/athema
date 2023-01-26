package com.athema.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.athema.dto.OptionDTO;
import com.athema.frame.AthemaMapper;

@Repository
@Mapper
public interface OptionMapper extends AthemaMapper<Integer, OptionDTO>{

}
