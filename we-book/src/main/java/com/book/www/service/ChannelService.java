package com.book.www.service;

import com.book.www.entity.Channel;
import com.book.www.mapper.ChannelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:FanMingxin
 * @Date: 2018/7/3 20:43
 * @Description:
 */
@Service
public class ChannelService {

    @Autowired
    private ChannelMapper channelMapper;

    public Channel getByClassifyId(long clId){
        return channelMapper.getByClassifyId(clId);
    }

    public Channel get(long id){
        return channelMapper.selectById(id);
    }
}
