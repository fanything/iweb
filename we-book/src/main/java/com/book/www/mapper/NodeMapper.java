package com.book.www.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.book.www.entity.Node;

/**
 * @Author:FanMingxin
 * @Date: 2018/6/30 15:55
 * @Description:
 */
public interface NodeMapper extends BaseMapper<Node>{

    public String getContent(long nodeId);
}
