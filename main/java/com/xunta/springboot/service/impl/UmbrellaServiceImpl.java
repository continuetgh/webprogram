package com.xunta.springboot.service.impl;

import com.xunta.springboot.entity.Umbrella;
import com.xunta.springboot.mapper.UmbrellaMapper;
import com.xunta.springboot.service.IUmbrellaService;
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
@Service("umbrellaService")
public class UmbrellaServiceImpl extends ServiceImpl<UmbrellaMapper, Umbrella> implements IUmbrellaService {
@Resource
    private UmbrellaMapper umbrellaMapper;
}
