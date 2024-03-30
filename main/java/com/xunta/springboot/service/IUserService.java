package com.xunta.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.school.springboot.controller.dto.UserDTO;
import com.school.springboot.controller.dto.UserPasswordDTO;
import com.xunta.springboot.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author school
 * @since 2023-04-08
 */
public interface IUserService extends IService<User> {
    UserDTO login(UserDTO userDTO);

    User register(UserDTO userDTO);

    void updatePassword(UserPasswordDTO userPasswordDTO);
    //更新头像

}
