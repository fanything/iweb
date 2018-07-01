package com.iweb.context.page;

import lombok.Data;

import java.util.List;

/**
 * @author fanmingxin
 * @description
 * @Date 2018/6/2
 */
@Data
public class Page {

    /**
     * 页码，从1开始
     */
    private int pageNum;
    /**
     * 页码，从1开始
     */
    private int currentPage;
    /**
     * 页面大小
     */
    private int pageSize;
    /**
     * 总数
     */
    private long totalCount;
    /**
     * 总页数
     */
    private int pageCount;

    private List list;

    public Page() {
    }

    public Page(int currentPage,int pageSize) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }
}
