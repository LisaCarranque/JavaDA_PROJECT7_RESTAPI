package com.nnk.springboot.config;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;


@Service("customUserDetailsService")
public class CustomUserDetailsService {
/*public class CustomUserDetailsService implements UserDetailsService {*/

    @Autowired
    private UserService userService;

/*    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

         if (username.trim().isEmpty()) {
            throw new UsernameNotFoundException("username is empty");
        }

        User user = userService.getByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User " + username + " not found");
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getGrantedAuthorities(user));
    }

    private List<GrantedAuthority> getGrantedAuthorities(User user) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        String role = user.getRole();
        authorities.add(new SimpleGrantedAuthority(role));
        return authorities;
    }*/

}