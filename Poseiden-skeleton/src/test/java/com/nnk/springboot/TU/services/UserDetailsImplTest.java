package com.nnk.springboot.TU.services;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.services.UserDetailsImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserDetailsImplTest {

    @InjectMocks
    UserDetailsImpl userDetails;

    @Test
    public void setUserDetails() {
        UserDetailsImpl userDetails = new UserDetailsImpl(1, "user", "password", new SimpleGrantedAuthority("admin"));
        assertNotNull(userDetails);
        assertEquals("user", userDetails.getUsername());
        assertEquals(Integer.valueOf(1), userDetails.getId());
        assertEquals("password", userDetails.getPassword());
        assertEquals(List.of("admin").toString(), userDetails.getAuthorities().toString());
    }

    @Test
    public void build() {
        User user = User.builder().id(1).username("user").password("password").role(new SimpleGrantedAuthority("admin").toString()).build();
        UserDetailsImpl userDetailsImpl = UserDetailsImpl.build(user);
        assertNotNull(userDetailsImpl);
        assertEquals("user", userDetailsImpl.getUsername());
        assertEquals(Integer.valueOf(1), userDetailsImpl.getId());
        assertEquals("password", userDetailsImpl.getPassword());
        assertEquals(List.of("admin").toString(), userDetailsImpl.getAuthorities().toString());
    }

    @Test
    public void equals() {
        User user1 = User.builder().id(1).username("user").password("password").role(new SimpleGrantedAuthority("admin").toString()).build();
        UserDetailsImpl userDetailsImpl1 = UserDetailsImpl.build(user1);
        User user2 = User.builder().id(1).username("user").password("password").role(new SimpleGrantedAuthority("admin").toString()).build();
        UserDetailsImpl userDetailsImpl2 = UserDetailsImpl.build(user2);
        assertTrue(userDetailsImpl1.equals(userDetailsImpl1));
        assertFalse(userDetailsImpl1.equals(null));
        Object user = new Object();
        assertFalse(userDetailsImpl1.equals(user));
    }

}
