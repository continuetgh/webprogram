package com.xunta.springboot.mapper;

import com.xunta.springboot.entity.NameNumber;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PieMapper {

    @Select("select count(*) from xunta_card")
    public List<NameNumber> findNameNumber();
}