package com.nnk.springboot.TU.controllers;

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
public class UserControllerTest {

    @Mock
    UserService userService;

    @InjectMocks
    UserController userController;

    @Spy
    BindingResult bindingResult;

    @Spy
    Model model;

    @Test
    public void home() {
        userController.home(model);
        verify(userService, times(1)).findAll();
    }

    @Test
    public void validate() {
        User user = User.builder().id(1).username("User Name")
                .fullname("Full Name").password("Password$2021").role("Role").build();
        userController.validate(user, bindingResult, model);
        verify(userService, times(1)).getByUsername("User Name");
        verify(userService, times(1)).add(user);
    }

    @Test
    public void validateUsernameUnavailable() {
        User user = User.builder().id(1).username("User Name")
                .fullname("Full Name").password("Password$2021").role("Role").build();
        when(userService.getByUsername(user.getUsername())).thenReturn(user);
        userController.validate(user, bindingResult, model);
        verifyNoMoreInteractions(userService);
    }

    @Test
    public void validatePasswordInvalid() {
        User user = User.builder().id(1).username("User Name")
                .fullname("Full Name").password("Password").role("Role").build();
        when(userService.getByUsername(user.getUsername())).thenReturn(null);
        userController.validate(user, bindingResult, model);
        verifyNoMoreInteractions(userService);
    }

    @Test
    public void validateCredentialsInvalid() {
        User user = User.builder().id(1).username("User Name")
                .fullname("Full Name").password("").role("Role").build();
        when(userService.getByUsername(user.getUsername())).thenReturn(null);
        userController.validate(user, bindingResult, model);
        verifyNoMoreInteractions(userService);
    }

    @Test
    public void showUpdateForm() {
        User user = User.builder().id(1).username("User Name")
                .fullname("Full Name").password("Password").role("Role").build();
        when(userService.getById(1)).thenReturn(user);
        userController.showUpdateForm(1, model);
        verify(userService, times(1)).getById(1);
    }

    @Test
    public void updateBid() {
        User user = User.builder().id(1).username("User Name")
                .fullname("Full Name").password("Password").role("Role").build();
        userController.updateUser(1, user, bindingResult, model);
        verify(userService, times(1)).update(user);
        verify(userService, times(1)).findAll();
    }

    @Test
    public void deleteBid() {
        User user = User.builder().id(1).username("User Name")
                .fullname("Full Name").password("Password").role("Role").build();
        when(userService.getById(1)).thenReturn(user);
        userController.deleteUser(1, model);
        verify(userService, times(1)).getById(1);
        verify(userService, times(1)).delete(user);
    }

}

