package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.services.IUserService;
import com.nnk.springboot.utils.UserUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * This class is responsible for mapping User CRUD
 */
@Log4j2
@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/user/list")
    public String home(Model model) {
        model.addAttribute("users", userService.findAll());
        log.trace("Display user/list view");
        return "user/list";
    }

    @GetMapping("/user/add")
    public String addUser(User bid) {
        log.trace("Display user/add view");
        return "user/add";
    }

    @PostMapping("/user/validate")
    public String validate(@Valid User user, BindingResult result, Model model) {
        if (userService.getByUsername(user.getUsername()) != null) {
            log.error("username unavailable");
            String errorMessage = "Username unavailable";
            model.addAttribute("errorMessage", errorMessage);
            log.trace("Display user/add view");
            return "user/add";
        }
        if (!result.hasErrors()) {
            if (!UserUtils.validatePassword(user.getPassword())) {
                log.error("invalid user password send for registration");
                String errorMessage = "Password should contain at least one small letter, one capital letter,\" +\n" +
                        "  8 characters, one number and one symbol";
                model.addAttribute("errorMessage", errorMessage);
                log.trace("Display user/add view");
                return "/user/add";
            }
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            user.setPassword(encoder.encode(user.getPassword()));
            userService.add(user);
            log.info("new user saved into database: "+user.getId());
            String successMessage = "Account created";
            model.addAttribute("successMessage", successMessage);
            model.addAttribute("users", userService.findAll());
            log.trace("Display login view");
            return "login";
        } else {
            log.error("Invalid user credentials send for registration");
            String errorMessage = "Invalid data. Please check your data.";
            model.addAttribute("errorMessage", errorMessage);
            log.trace("Display user/add view");
            return "user/add";
        }
    }

    @GetMapping("/user/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        User user = userService.getById(id);
        log.info("user to update selected from database" + user.getId());
        user.setPassword("");
        model.addAttribute("user", user);
        log.trace("Redirect to user/update view");
        return "user/update";
    }

    @PostMapping("/user/update/{id}")
    public String updateUser(@PathVariable("id") Integer id, @Valid User user,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            log.error("invalid user data send for update");
            return "user/update";
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        user.setId(id);
        userService.update(user);
        log.info("user information successfully updated for user:"+user.getId());
        model.addAttribute("users", userService.findAll());
        log.trace("Redirect to user/list view");
        return "redirect:/user/list";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, Model model) {
        User user = userService.getById(id);
        log.info("user selected from database");
        userService.delete(user);
        log.info("user successfully removed from database");
        model.addAttribute("users", userService.findAll());
        log.info("Redirect to user/list view");
        return "redirect:/user/list";
    }
}
