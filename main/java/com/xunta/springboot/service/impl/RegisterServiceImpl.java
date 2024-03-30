package com.xunta.springboot.service.impl;

import com.xunta.springboot.entity.Register;
import com.xunta.springboot.mapper.RegisterMapper;
import com.xunta.springboot.service.IRegisterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author school
 * @since 2024-03-28
 */
@Service
public class RegisterServiceImpl extends ServiceImpl<RegisterMapper, Register> implements IRegisterService {

}
