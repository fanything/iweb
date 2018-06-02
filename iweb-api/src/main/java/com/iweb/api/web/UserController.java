package com.iweb.api.web;

import com.iweb.api.entity.User;
import com.iweb.api.service.UserService;
import com.iweb.context.annotation.RestCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RestCode
    @PostMapping("")
    public Object add(User user){
        userService.add(user);
        return "ok";
    }
}
