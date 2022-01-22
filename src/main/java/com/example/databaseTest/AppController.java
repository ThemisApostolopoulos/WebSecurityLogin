package com.example.databaseTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Date;

@Controller
public class AppController {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private LoggingRepository loggingRepository;

    @GetMapping("")
    public String viewIndex(){
        return "index";
    }

    @GetMapping("/hello")
    public String viewHello(Principal user){
        System.out.println("USERNAME: "+user.getName());
        loggingRepository.save(new Logging(user.getName(), new Date()));
        return "hello";
    }

    @GetMapping("/login")
    public String viewLogin(){
        return "login";
    }
}
