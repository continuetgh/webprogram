package com.xunta.springboot.service.impl;

import com.xunta.springboot.entity.Files;
import com.xunta.springboot.mapper.FileMapper;
import com.xunta.springboot.service.IFileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author school
 * @since 2023-04-14
 */
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, Files> implements IFileService {

}
