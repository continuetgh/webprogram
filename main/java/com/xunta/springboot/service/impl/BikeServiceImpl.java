package com.xunta.springboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xunta.springboot.entity.Bike;
import com.xunta.springboot.mapper.BikeMapper;
import com.xunta.springboot.service.IBikeService;
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
@Service("bikeService")
public class BikeServiceImpl extends ServiceImpl<BikeMapper, Bike> implements IBikeService {

    @Resource
    private BikeMapper bikeMapper;

}
