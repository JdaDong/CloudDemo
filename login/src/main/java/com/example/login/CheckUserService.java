package com.example.login;

import com.example.login.annotation.AdminOnly;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
@Component
public class CheckUserService {

    private Logger logger = Logger.getLogger(CheckUserService.class.getName());

    @AdminOnly
    public void checkUserLogin() throws Exception{
        logger.log(Level.INFO, "checkuserservice in");
        throw new Exception("error");
    }


    public void checkUserAlive(){
        logger.log(Level.INFO, "alive in");
    }
}

