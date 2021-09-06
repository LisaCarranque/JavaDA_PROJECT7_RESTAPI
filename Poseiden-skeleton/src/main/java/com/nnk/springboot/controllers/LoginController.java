package com.nnk.springboot.controllers;

import com.nnk.springboot.config.LoginRequest;
import com.nnk.springboot.repositories.UserRepository;
import com.nnk.springboot.services.IUserService;
import com.nnk.springboot.utils.JwtUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * This class is responsible for mapping login access.
 * It handles login requests.
 */
@Log4j2
@Controller
public class LoginController {

    @Autowired
    private IUserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtil jwtUtils;

    @GetMapping("error")
    public String error(Model model) {
        String errorMessage = "You are not authorized for the requested data.";
        model.addAttribute("errorMessage", errorMessage);
        return "error";
    }

    // Login form with error
    @RequestMapping("/login-error")
    public String loginError(Model model) {
        log.error("invalid user login attempt");
        model.addAttribute("loginError", "invalid user credentials or session");
        log.trace("Display login view");
        return "login";
    }



    @RequestMapping(value = "/authenticate",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String authenticateUser(@Valid LoginRequest loginRequest,
                                   HttpServletResponse response, Model model) {

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtUtils.generateJwtToken(authentication);

            Cookie cookie = new Cookie("token", jwt);
            cookie.setSecure(true);
            cookie.setHttpOnly(true);
            cookie.setPath("/");
            cookie.setMaxAge(10000);
            response.addCookie(cookie);

            return "home";
        } catch (Exception e) {
            String errorMessage = "Invalid credentials";
            model.addAttribute("errorMessage",errorMessage);
            return "login";
        }
    }
}
