package com.xunta.springboot.mapper;

import com.xunta.springboot.entity.Find;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author school
 * @since 2023-04-08
 */
@Mapper
@Repository
public interface FindMapper extends BaseMapper<Find> {

}