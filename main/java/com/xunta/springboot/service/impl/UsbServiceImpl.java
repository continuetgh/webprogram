package com.xunta.springboot.service.impl;

import com.xunta.springboot.entity.Usb;
import com.xunta.springboot.mapper.UsbMapper;
import com.xunta.springboot.service.IUsbService;
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
@Service("usbService")
public class UsbServiceImpl extends ServiceImpl<UsbMapper, Usb> implements IUsbService {
@Resource
    private UsbMapper usbMapper;
}
