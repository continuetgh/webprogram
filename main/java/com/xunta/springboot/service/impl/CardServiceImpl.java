package com.xunta.springboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xunta.springboot.entity.Card;
import com.xunta.springboot.mapper.CardMapper;
import com.xunta.springboot.service.ICardService;
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
@Service("cardService")
public class CardServiceImpl extends ServiceImpl<CardMapper, Card> implements ICardService {
    @Resource
    private CardMapper cardMapper;

}
