package com.iweb.api.service;

import com.iweb.api.domain.UserDomain;
import com.iweb.api.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDomain userDomain;

    public void add(User user){
        userDomain.insert(user);
    }
}
