package com.iweb.api.web;

import com.iweb.api.entity.User;
import com.iweb.api.service.UserService;
import com.iweb.context.annotation.RestCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RestCode
    @PostMapping("")
    public Object add(@RequestBody User user){
        userService.add(user);
        return "ok";
    }

    @RestCode
    @GetMapping("")
    public Object get(@RequestParam("userId") int userId){
        return userService.get(userId);
    }

    @RestCode
    @GetMapping("/list")
    public Object list(@RequestParam("currentPage") int currentPage){
        return userService.list(currentPage);
    }
}
