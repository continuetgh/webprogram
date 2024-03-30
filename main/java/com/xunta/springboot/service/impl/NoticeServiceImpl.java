package com.xunta.springboot.service.impl;

import com.xunta.springboot.entity.Notice;
import com.xunta.springboot.mapper.NoticeMapper;
import com.xunta.springboot.service.INoticeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author school
 * @since 2023-04-15
 */
@Service("noticeService")
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements INoticeService {

}
