package com.nnk.springboot.TU.controllers;

import com.nnk.springboot.controllers.HomeController;
import com.nnk.springboot.controllers.UserController;
import com.nnk.springboot.domain.User;
import com.nnk.springboot.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class HomeControllerTest {


    @Mock
    UserService userService;

    @InjectMocks
    HomeController homeController;

    @Spy
    BindingResult bindingResult;

    @Spy
    Model model;

    @Test
    public void home() {
        homeController.home(model);
        verifyNoInteractions(userService);
    }

    @Test
    public void validate() {
        homeController.adminHome(model);
        verify(userService, times(1)).findAll();
    }


}

