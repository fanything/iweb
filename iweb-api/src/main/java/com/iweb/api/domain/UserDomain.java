package com.iweb.api.domain;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.iweb.api.entity.User;
import com.iweb.api.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDomain {

    @Autowired
    private UserMapper userMapper;

    public User insert(User user){
        userMapper.insert(user);
        return user;
    }

    public Object get(Integer userId) {
        return userMapper.selectById(userId);
    }

    public Object list(int currentPage){
        Page p = new Page<User>(currentPage,2);
        return userMapper.selectPage(p, new EntityWrapper<>(null));
    }
}
