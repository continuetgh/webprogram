package com.xunta.springboot.service.impl;

import com.xunta.springboot.entity.Certificate;
import com.xunta.springboot.mapper.CertificateMapper;
import com.xunta.springboot.service.ICertificateService;
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
@Service("certificateService")
public class CertificateServiceImpl extends ServiceImpl<CertificateMapper, Certificate> implements ICertificateService {
    @Resource
    private CertificateMapper certificateMapper;

}
