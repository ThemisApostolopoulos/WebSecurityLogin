package com.example.databaseTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    @Autowired
    private UserRepository userRepo;

    @GetMapping("")
    public String viewIndex(){
        return "index";
    }

    @GetMapping("/hello")
    public String viewHello(){
        return "hello";
    }
}
