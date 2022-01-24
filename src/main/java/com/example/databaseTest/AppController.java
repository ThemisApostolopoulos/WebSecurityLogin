package com.example.databaseTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.security.Security;
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

    @GetMapping("/successLogin")
    public ModelAndView passWordChange(ModelMap model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication!=null){
            String username = authentication.getName();
            User user = userRepo.findByUsername(username);
            long lockTimeInMillis = user.getPasswordSet().getTime();
            long currentTimeInMillis = System.currentTimeMillis();
            //2 minute timer to change password
            if(currentTimeInMillis - lockTimeInMillis > 2*60*1000){
                return new ModelAndView("redirect:/hello?error", model);
            }
            return new ModelAndView("redirect:/hello", model);
        }
        return null;
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
