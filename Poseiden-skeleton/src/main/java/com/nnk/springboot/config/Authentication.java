package com.nnk.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class Authentication {

    @Autowired
    AuthenticationManager authenticationManager;

    String username;
    String password;

    Authentication authentication =
            (Authentication) authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );


}
