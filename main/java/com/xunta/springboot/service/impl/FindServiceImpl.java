package com.xunta.springboot.service.impl;

import com.xunta.springboot.entity.Find;
import com.xunta.springboot.mapper.FindMapper;
import com.xunta.springboot.service.IFindService;
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
@Service(" findService")
public class FindServiceImpl extends ServiceImpl<FindMapper, Find> implements IFindService {
    @Resource
    private FindMapper findMapper;

}
