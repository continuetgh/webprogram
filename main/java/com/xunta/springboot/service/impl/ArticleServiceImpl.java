package com.xunta.springboot.service.impl;

import com.xunta.springboot.entity.Article;
import com.xunta.springboot.mapper.ArticleMapper;
import com.xunta.springboot.service.IArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author school
 * @since 2023-04-12
 */
@Service("articleService")
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

}
