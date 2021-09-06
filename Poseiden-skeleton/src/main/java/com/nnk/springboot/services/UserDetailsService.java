package com.nnk.springboot.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *  This interface has a method to load User by username and returns a UserDetails object
 *  that Spring Security can use for authentication and validation.
 */
public interface UserDetailsService {
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}

