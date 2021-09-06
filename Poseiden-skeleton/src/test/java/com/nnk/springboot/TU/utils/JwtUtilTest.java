package com.nnk.springboot.TU.utils;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.services.UserDetailsImpl;
import com.nnk.springboot.utils.JwtUtil;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class JwtUtilTest {

    @Mock
    Authentication authentication;

    @InjectMocks
    JwtUtil jwtUtil;

    @Test
    public void generateJwtToken() {
        ReflectionTestUtils.setField(jwtUtil, "jwtSecret", "jwtSecret");
        when(authentication.getPrincipal()).thenReturn(new UserDetailsImpl(1, "user", "password", new SimpleGrantedAuthority("admin")));
        String jts = jwtUtil.generateJwtToken(authentication);
        assertNotNull(jts);
    }

    @Test
    public void getUserNameFromJwtToken() {
        ReflectionTestUtils.setField(jwtUtil, "jwtSecret", "jwtSecret");
        ReflectionTestUtils.setField(jwtUtil, "jwtExpirationMs", 86400000);
        when(authentication.getPrincipal()).thenReturn(new UserDetailsImpl(1, "user", "password", new SimpleGrantedAuthority("admin")));
        String jts = jwtUtil.generateJwtToken(authentication);
        String user = jwtUtil.getUserNameFromJwtToken(jts);
        assertNotNull(user);
        assertEquals("user", user);
    }

    @Test
    public void validateJwtTokenValidCase() {
        ReflectionTestUtils.setField(jwtUtil, "jwtSecret", "jwtSecret");
        ReflectionTestUtils.setField(jwtUtil, "jwtExpirationMs", 86400000);
        when(authentication.getPrincipal()).thenReturn(new UserDetailsImpl(1, "user", "password", new SimpleGrantedAuthority("admin")));
        String jts = jwtUtil.generateJwtToken(authentication);
        assertTrue(jwtUtil.validateJwtToken(jts));
    }



    @Test
    public void validateJwtTokenExpiredCase() {
        ReflectionTestUtils.setField(jwtUtil, "jwtSecret", "jwtSecret");
        when(authentication.getPrincipal()).thenReturn(new UserDetailsImpl(1, "user", "password", new SimpleGrantedAuthority("admin")));
        String jts = jwtUtil.generateJwtToken(authentication);
        assertFalse(jwtUtil.validateJwtToken(jts));
    }

    @Test
    public void validateJwtTokenInvalidFormat() {
        String jts = "1234567890";
        assertFalse(jwtUtil.validateJwtToken(jts));
    }

    @Test
    public void validateJwtTokenEmptyToken() {
        String jts = "";
        assertFalse(jwtUtil.validateJwtToken(jts));
    }
}
