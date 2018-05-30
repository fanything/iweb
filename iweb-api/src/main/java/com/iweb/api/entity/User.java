package com.iweb.api.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

@Data
@TableName("w_user")
public class User {

    @TableId
    private long id;

    private String loginName;

    private String password;
}
