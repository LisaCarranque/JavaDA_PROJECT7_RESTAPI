package com.nnk.springboot.controllers;

import com.nnk.springboot.config.CustomUserDetailsService;
import com.nnk.springboot.services.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This class is responsible for mapping Home access
 */
@Log4j2
@Controller
public class HomeController {

    @Autowired
    UserService userService;

    @Autowired
    CustomUserDetailsService userDetailsService;

    @Autowired
    AuthenticationManager authenticationManager;


    @RequestMapping("/welcome")
    public String home(Model model) {
        log.trace("Display home view");
        return "home";
    }

    @RequestMapping("/admin/home")
    public String adminHome(Model model) {
        model.addAttribute("users", userService.findAll());
        log.trace("Display admin consol");
        return "redirect:/user/list";
    }
}
