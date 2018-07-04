package com.book.www.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.book.www.entity.Book;

/**
 * @Author:FanMingxin
 * @Date: 2018/6/30 15:55
 * @Description:
 */
public interface BookMapper extends BaseMapper<Book>{

    Book getFull(final long id);
}
