package com.iweb.api.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iweb.api.domain.UserDomain;
import com.iweb.api.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDomain userDomain;

    public void add(User user){
        userDomain.insert(user);
    }

    public Object get(Integer userId) {
        return userDomain.get(userId);
    }

    public Object list(Integer currentPage) {
        return userDomain.list(currentPage);
    }
}
