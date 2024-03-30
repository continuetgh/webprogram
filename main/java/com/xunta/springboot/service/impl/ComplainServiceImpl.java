package com.xunta.springboot.service.impl;

import com.xunta.springboot.entity.Complain;
import com.xunta.springboot.mapper.ComplainMapper;
import com.xunta.springboot.service.IComplainService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author school
 * @since 2024-03-29
 */
@Service
public class ComplainServiceImpl extends ServiceImpl<ComplainMapper, Complain> implements IComplainService {

}
