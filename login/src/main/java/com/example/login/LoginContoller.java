package com.example.login;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/login")
public class LoginContoller {

    private static Logger logger =  Logger.getLogger(LoginContoller.class.getName());

    @Autowired
    private CheckUserService checkUserService;

    @RequestMapping("/loginFirst")
    public void loginFirst() {
        try {
            checkUserService.checkUserLogin();
        } catch (Exception e) {
            logger.log(Level.INFO, e.getMessage());

        }finally {
            checkUserService.checkUserAlive();
        }
    }

    @RequestMapping("/loginPage")
    public void loginPage(){
        logger.info("login");
    }

    @GetMapping("/me1")
    public Object currentUser() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @GetMapping("/me2")
    public Object currentUser(Authentication authentication) {
        return authentication;
    }

    /**
     * @param userDetails
     * @return 只包含了userDetails
     */
    @GetMapping("/me3")
    public Object cuurentUser(@AuthenticationPrincipal UserDetails userDetails) {
        return userDetails;
    }
}
