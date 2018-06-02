package com.iweb.api.domain;

import com.iweb.api.entity.User;
import com.iweb.api.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
