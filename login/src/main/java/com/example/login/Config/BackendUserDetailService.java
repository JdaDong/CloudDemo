package com.example.login.Config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class BackendUserDetailService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(BackendUserDetailService.class.getName());


    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        logger.info("name" + name);
      //  UserDetails userDetailsService = new User()

   //     UserDetails userDetails = new SpringSecurityUser();
        return null;
    }
}
