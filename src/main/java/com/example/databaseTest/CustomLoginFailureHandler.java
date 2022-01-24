package com.example.databaseTest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomLoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {


    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Autowired
    private UserRepository userRepository;

    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException{
        String username = request.getParameter("username");
        //UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
        User user = userRepository.findByUsername(username);
        if(user!=null){
            if(!user.isAccountLocked()){
                if(user.getFailedAttempts() < customUserDetailsService.MAX_FAILED_ATTEMPTS - 1){
                    customUserDetailsService.increaseFailedAttempts(user);
                }else {
                    customUserDetailsService.lockUser(user);
                    exception = new LockedException("Your account has been locked due to 3 failed attempts.It will be unlocked in 1 minute");
                }
            }else if(user.isAccountLocked()){
                if(customUserDetailsService.unlockWhenTimeExpired(user)){
                    exception = new LockedException("Your account has been unlocked. Please try to login again.");
                }
            }
        }

        super.setDefaultFailureUrl("/login?error");
        super.onAuthenticationFailure(request, response, exception);


    }
}
