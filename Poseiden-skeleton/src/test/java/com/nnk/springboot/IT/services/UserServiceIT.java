package com.nnk.springboot.IT.services;

import com.nnk.springboot.Application;
import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.TradeRepository;
import com.nnk.springboot.repositories.UserRepository;
import com.nnk.springboot.services.TradeService;
import com.nnk.springboot.services.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest(classes = {Application.class, UserService.class})
@EnableJpaRepositories(basePackageClasses = {UserRepository.class})
@EntityScan(basePackageClasses = {User.class})
@ContextConfiguration
public class UserServiceIT {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @AfterEach
    public void deleteAll() {
        userService.clearDataBase();
    }

    @Test
    public void save() {
        User user = User.builder().username("Username").password("Password")
                .fullname("Fullname").role("USER").build();
        User userSaved = userService.add(user);
        assertNotNull(userSaved);
        assertEquals(userSaved.getUsername(), "Username");
    }

    @Test
    public void list() {
        List<User> users = userRepository.findAll();
        assertNotNull(users);
    }

    @Test
    public void delete() {
        List<User> users = userService.findAll();
        assertNotNull(users);
        int size = users.size();
        User user = userService.getById(200);
        userService.delete(user);
        List<User> userAfterDelete = userService.findAll();
        assertEquals(size - 1, userAfterDelete.size());
    }

}