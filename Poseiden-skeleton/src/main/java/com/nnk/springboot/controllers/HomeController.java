package com.nnk.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This class is responsible for mapping Home access
 */
@Controller
public class HomeController {
    @RequestMapping("/welcome")
    public String home(Model model) {
        return "home";
    }

    @RequestMapping("/admin/home")
    public String adminHome(Model model) {
        return "redirect:/user/list";
    }

}
