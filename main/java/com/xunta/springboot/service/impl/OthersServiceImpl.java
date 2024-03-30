package com.xunta.springboot.service.impl;

import com.xunta.springboot.entity.Others;
import com.xunta.springboot.mapper.OthersMapper;
import com.xunta.springboot.service.IOthersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author school
 * @since 2023-04-08
 */
@Service("othersService")
public class OthersServiceImpl extends ServiceImpl<OthersMapper, Others> implements IOthersService {
    @Resource
    private OthersMapper othersMapper;

}
