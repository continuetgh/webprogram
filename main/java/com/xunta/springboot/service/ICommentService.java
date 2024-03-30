package com.xunta.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xunta.springboot.entity.Comment;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author school
 * @since 2023-02-06
 */
public interface ICommentService extends IService<Comment> {

    List<Comment> findCommentDetail(Integer articleId);
}
