package com.book.www.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.book.www.entity.Book;
import com.book.www.entity.Node;
import com.book.www.mapper.BookMapper;
import com.book.www.mapper.NodeMapper;
import com.iweb.context.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:FanMingxin
 * @Date: 2018/6/30 15:44
 * @Description:
 */
@Service
public class BookService {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private NodeMapper nodeMapper;

    public Page list(Page page){
        Pagination pagination = new Pagination();
        pagination.setCurrent(page.getCurrentPage());
        pagination.setSize(page.getPageSize());
        List<Book> list = bookMapper.selectPage(pagination,new EntityWrapper<>(null));

        page.setList(list);
        return page;
    }

    public Book detail(int bookId) {
        return bookMapper.selectById(bookId);
    }

    public Object nodeList(int bookId, Page page) {
        Pagination pagination = new Pagination();
        pagination.setCurrent(page.getCurrentPage());
        pagination.setSize(page.getPageSize());

        Map<String,Object> param = new HashMap<>();
        param.put("book_id",bookId);
        List<Node> list = nodeMapper.selectPage(pagination,new EntityWrapper<Node>().allEq(param));

        page.setList(list);
        return page;
    }

    public Object content(int nodeId) {
        Node node = nodeMapper.selectById(nodeId);
        node.setContent(nodeMapper.getContent(nodeId));
        return node;
    }
}
