package com.xunta.springboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xunta.springboot.entity.Book;
import com.xunta.springboot.mapper.BookMapper;
import com.xunta.springboot.service.IBookService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author school
 * @since 2023-04-08
 */
@Service("bookservice")
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {
    private BookMapper bookMapper;

}
