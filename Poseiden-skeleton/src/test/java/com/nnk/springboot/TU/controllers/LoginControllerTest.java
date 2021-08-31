package com.nnk.springboot.TU.controllers;

import com.nnk.springboot.controllers.LoginController;
import com.nnk.springboot.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.net.Authenticator;

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

    @Test
    public void home() {
        loginController.home(model);
        verifyNoInteractions(userService);
    }

    @Test
    public void error() {
        loginController.error(model);
        verifyNoInteractions(userService);
    }

    @Test
    public void userList() {
        loginController.userList(model);
        verify(userService, times(1)).findAll();
    }

/*    @Test
    public void loginError() {
         lenient().when(authentication.getPrincipal()).thenReturn("anonymousUser");
        loginController.loginError(model);
        verifyNoInteractions(userService);
    }*/
}
