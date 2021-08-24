package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.services.IUserService;
import com.nnk.springboot.utils.UserUtils;
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
@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/user/list")
    public String home(Model model) {
        model.addAttribute("users", userService.findAll());
        return "user/list";
    }

    @GetMapping("/user/add")
    public String addUser(User bid) {
        return "user/add";
    }

    @PostMapping("/user/validate")
    public String validate(@Valid User user, BindingResult result, Model model) {
        if (userService.getByUsername(user.getUsername()) != null) {
            String errorMessage = "Username unavailable";
            model.addAttribute("errorMessage", errorMessage);
            return "user/add";
        }
        if (!result.hasErrors()) {
            if (!UserUtils.validatePassword(user.getPassword())) {
                String errorMessage = "Password should contain at least one small letter, one capital letter,\" +\n" +
                        "  8 characters, one number and one symbol";
                model.addAttribute("errorMessage", errorMessage);
                return "/user/add";
            }
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            user.setPassword(encoder.encode(user.getPassword()));
            userService.add(user);
            String successMessage = "Account created";
            model.addAttribute("successMessage", successMessage);
            model.addAttribute("users", userService.findAll());
            return "login";
        } else {
            String errorMessage = "Invalid data. Please check your data.";
            model.addAttribute("errorMessage", errorMessage);
            return "user/add";
        }
    }

    @GetMapping("/user/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        User user = userService.getById(id);
        user.setPassword("");
        model.addAttribute("user", user);
        return "user/update";
    }

    @PostMapping("/user/update/{id}")
    public String updateUser(@PathVariable("id") Integer id, @Valid User user,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "user/update";
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        user.setId(id);
        userService.update(user);
        model.addAttribute("users", userService.findAll());
        return "redirect:/user/list";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, Model model) {
        User user = userService.getById(id);
        userService.delete(user);
        model.addAttribute("users", userService.findAll());
        return "redirect:/user/list";
    }
}
