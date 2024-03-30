package com.xunta.springboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xunta.springboot.entity.Comment;
import com.xunta.springboot.mapper.CommentMapper;
import com.xunta.springboot.service.ICommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author school
 * @since 2023-02-06
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

    @Resource
    private CommentMapper commentMapper;

    @Override
    public List<Comment> findCommentDetail(Integer articleId) {

        return commentMapper.findCommentDetail(articleId);
    }
}
