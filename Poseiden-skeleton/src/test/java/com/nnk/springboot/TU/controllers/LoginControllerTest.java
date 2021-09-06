package com.nnk.springboot.TU.controllers;

import com.nnk.springboot.config.LoginRequest;
import com.nnk.springboot.controllers.LoginController;
import com.nnk.springboot.services.UserDetailsImpl;
import com.nnk.springboot.services.UserService;
import com.nnk.springboot.utils.JwtUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpServletResponse;
import java.net.Authenticator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LoginControllerTest {

    @Mock
    UserService userService;

    @InjectMocks
    LoginController loginController;

    @Spy
    BindingResult bindingResult;

    @Mock
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    @Spy
    Model model;

    @Mock
    LoginRequest loginRequest;

    @Mock
    HttpServletResponse response;

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private JwtUtil jwtUtil;

    @Mock
    private SecurityContextHolder securityContextHolder;

    @Test
    public void error() {
        loginController.error(model);
        verifyNoInteractions(userService);
    }


    @Test
    public void loginError() {
        loginController.loginError(model);
        verifyNoInteractions(userService);
        assertEquals("login", loginController.loginError(model));
    }

    @Test
    public void authenticateUser() {
        loginRequest.setUsername("user");
        loginRequest.setPassword("password");
        when(authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()))).thenReturn(authentication);
        when(jwtUtil.generateJwtToken(authentication)).thenReturn("1234567890");
        loginController.authenticateUser(loginRequest, response, model);
        verifyNoInteractions(userService);
        assertEquals("home", loginController.authenticateUser(loginRequest, response, model));
    }


}
