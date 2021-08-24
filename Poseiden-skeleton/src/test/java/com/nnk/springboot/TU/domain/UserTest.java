package com.nnk.springboot.TU.domain;

import com.nnk.springboot.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class UserTest {

    @Test
    public void setUser() {
        User user = User.builder().build();
        user.setPassword("password");
        user.setUsername("username");
        user.setId(1);
        user.setFullname("fullname");
        user.setRole("role");
        assertEquals(Integer.valueOf(1), user.getId());
        assertEquals("password", user.getPassword());
        assertEquals("username", user.getUsername());
        assertEquals("fullname", user.getFullname());
        assertEquals("role", user.getRole());
    }

    @Test
    public void getUser() {
        User user = User.builder().password("password")
                .username("username").fullname("fullname")
                .id(1).role("role").build();
        assertEquals(Integer.valueOf(1), user.getId());
        assertEquals("password", user.getPassword());
        assertEquals("username", user.getUsername());
        assertEquals("fullname", user.getFullname());
        assertEquals("role", user.getRole());
    }

}
