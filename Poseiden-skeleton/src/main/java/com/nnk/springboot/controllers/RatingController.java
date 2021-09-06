package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.services.IRatingService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * This class is responsible for mapping Rating CRUD
 */
@Log4j2
@Controller
public class RatingController {

    @Autowired
    IRatingService ratingService;

    @RequestMapping("/rating/list")
    public String home(Model model) {
        log.trace("Load rating data");
        model.addAttribute("ratings", ratingService.findAll());
        log.trace("Display rating/list view");
        return "rating/list";
    }

    @GetMapping("/rating/add")
    public String addRatingForm(Rating rating) {
        log.trace("Display rating/add view");
        return "rating/add";
    }

    @PostMapping("/rating/validate")
    public String validate(@Valid Rating rating, BindingResult result, Model model) {
        if (result.hasErrors()) {
            log.error("Invalid rating");
            return "/rating/add";
        } else {
            log.info("New rating added: " + rating.getId());
            ratingService.add(rating);
            model.addAttribute("ratings", ratingService.findAll());
            log.trace("Redirect to rating/list view");
            return "redirect:/rating/list";
        }
    }

    @GetMapping("/rating/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("ratingToUpdate", ratingService.getById(id));
        log.info("Rating to update selected by id: " + id);
        log.trace("Display rating/update view");
        return "rating/update";
    }

    @PostMapping("/rating/update/{id}")
    public String updateRating(@PathVariable("id") Integer id, @Valid Rating rating,
                               BindingResult result, Model model) {
        ratingService.update(rating);
        log.info("rating updated: " + id);
        model.addAttribute("ratings", ratingService.findAll());
        log.trace("Redirect to rating/list view");
        return "redirect:/rating/list";
    }

    @GetMapping("/rating/delete/{id}")
    public String deleteRating(@PathVariable("id") Integer id, Model model) {
        log.info("rating deleted: " + id);
        ratingService.delete(ratingService.getById(id));
        model.addAttribute("ratings", ratingService.findAll());
        log.trace("Redirect to rating/list view");
        return "redirect:/rating/list";
    }
}
