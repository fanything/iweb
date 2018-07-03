package com.book.www.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.book.www.entity.Channel;

/**
 * @Author:FanMingxin
 * @Date: 2018/6/30 15:55
 * @Description:
 */
public interface ChannelMapper extends BaseMapper<Channel>{

    Channel getByClassifyId(long clId);
}
