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
@TableName("n_book")
public class Book {

    @TableId
    private long id;

    private String name;

    private String author;

    private long channelId;
    private long classifyId;

    private String img;

    private String intro;

    private int wcount;

    @TableField("width")
    private int imgWidth;

    @TableField("height")
    private int imgHeight;
}
