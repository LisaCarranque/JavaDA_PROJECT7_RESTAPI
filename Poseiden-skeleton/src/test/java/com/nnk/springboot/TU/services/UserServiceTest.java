package com.nnk.springboot.TU.services;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.UserRepository;
import com.nnk.springboot.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    @Test
    public void findAll() {
        List<User> users = userService.findAll();
        verify(userRepository, times(1)).findAll();
    }

    @Test
    public void add() {
        User user = User.builder().id(1).username("username").role("role")
                .fullname("fullname").password("password").build();
        userService.add(user);
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void update() {
        User user = User.builder().id(1).username("username").role("role")
                .fullname("fullname").password("password").build();
        userService.update(user);
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void getById() {
        assertThrows(IllegalArgumentException.class, () -> {
            userService.getById(1);
        });
    }

    @Test
    public void delete() {
        User user = User.builder().id(1).username("username").role("role")
                .fullname("fullname").password("password").build();
        userService.delete(user);
        verify(userRepository, times(1)).delete(user);
    }

    @Test
    public void getByUsername() {
        User user = User.builder().id(1).username("username").role("role")
                .fullname("fullname").password("password").build();
        userService.getByUsername(user.getUsername());
        verify(userRepository, times(1)).getByUsername(user.getUsername());
    }

}
