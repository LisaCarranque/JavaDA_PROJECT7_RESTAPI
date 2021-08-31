package com.nnk.springboot.controllers;

import com.nnk.springboot.services.IUserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * This class is responsible for mapping login access
 */
@Log4j2
@Controller
public class LoginController {

    @Autowired
    private IUserService userService;

    @GetMapping("login")
    public String home(Model model) {
        log.trace("Display login view");
        return "login";
    }

    // Login form with error
    @RequestMapping("/login-error.html")
    public String loginError(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
         if  (authentication.getPrincipal().equals("anonymousUser")) {
             log.error("invalid user login attempt");
            model.addAttribute("loginError", "invalid user credentials or session");
        }
         log.trace("Display login view");
        return "login.html";
    }

    @GetMapping("secure/article-details")
    public String userList(Model model) {
        model.addAttribute("users", userService.findAll());
        log.trace("Display user list");
        return "user/list";
    }

    @GetMapping("error")
    public String error(Model model) {
        String errorMessage = "You are not authorized for the requested data.";
        model.addAttribute("errorMessage", errorMessage);
        return "error";
    }
}
