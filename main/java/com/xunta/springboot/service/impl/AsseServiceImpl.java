package com.xunta.springboot.service.impl;

import com.xunta.springboot.entity.Asse;
import com.xunta.springboot.mapper.AsseMapper;
import com.xunta.springboot.service.IAsseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author school
 * @since 2023-04-13
 */
@Service("asseService")
public class AsseServiceImpl extends ServiceImpl<AsseMapper, Asse> implements IAsseService {

}
