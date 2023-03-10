package com.athema.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.athema.dto.PreferDTO;
import com.athema.frame.AthemaMapper;

@Repository
@Mapper
public interface PreferMapper extends AthemaMapper<Integer, PreferDTO>{

}
