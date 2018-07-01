package com.book.www.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

/**
 * @Author:FanMingxin
 * @Date: 2018/6/30 15:47
 * @Description:
 */
@Data
@TableName("n_node")
public class Node {

    @TableId
    private long id;

    private long bookId;

    private String name;

    private String keywords;

    private String intro;

    private int wcount;

    public long beforeId;

    public long afterId;

    public String createTime;

    @TableField(exist = false)
    public String content;
}
