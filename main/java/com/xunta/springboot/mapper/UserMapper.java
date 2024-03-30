package com.xunta.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.school.springboot.controller.dto.UserPasswordDTO;
import com.xunta.springboot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

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
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from xunta_user where type not like'0'")
    List<User> findAll(String type);
    @Update("update student_user set password = #{newPassword} where username = #{username} and password = #{password}")
    int updatePassword(UserPasswordDTO userPasswordDTO);
}
