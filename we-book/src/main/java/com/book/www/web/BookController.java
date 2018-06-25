package com.book.www.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class BookController {


    @GetMapping("/details")
    public Object details(@RequestParam("id") int id){
        return "ok";
    }

    @GetMapping("/list")
    public Object list(@RequestParam("currentPage") int currentPage){
        return "ok";
    }
}
