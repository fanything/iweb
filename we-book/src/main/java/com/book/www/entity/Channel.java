package com.book.www.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

/**
 * @Author:FanMingxin
 * @Date: 2018/7/3 20:37
 * @Description:
 */
@Data
@TableName("n_channel")
public class Channel {

    @TableId
    private long id;

    private String name;
}
