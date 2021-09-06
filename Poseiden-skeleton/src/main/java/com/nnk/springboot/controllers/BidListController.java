package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.services.IBidListService;
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
 * This class is responsible for mapping BidList CRUD
 */
@Log4j2
@Controller
public class BidListController {

    @Autowired
    IBidListService bidListService;

    @RequestMapping("/bidList/list")
    public String home(Model model) {
        log.trace("Load bid list");
        model.addAttribute("bidList", bidListService.findAll());
        log.trace("Display bidList/list view");
        return "bidList/list";
    }

    @GetMapping("/bidList/add")
    public String addBidForm(BidList bid) {
        log.trace("Display bidList/add view");
        return "bidList/add";
    }

    @PostMapping("/bidList/validate")
    public String validate(@Valid BidList bid, BindingResult result, Model model) {
        if (result.hasErrors()) {
            log.error("Invalid bidList");
            return "bidList/add";
        } else {
            bidListService.add(bid);
            log.info("New bid added: " + bid.getBidListId());
            model.addAttribute("bidList", bidListService.findAll());
            log.trace("Redirect to bidList/list view");
            return "redirect:/bidList/list";
        }
    }

    @GetMapping("/bidList/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("bidListToUpdate", bidListService.getById(id));
        log.info("BidList to update selected by id: " + id);
        log.trace("Display bidList/update view");
        return "bidList/update";
    }

    @PostMapping("/bidList/update/{id}")
    public String updateBid(@PathVariable("id") Integer id, @Valid BidList bidList,
                            BindingResult result, Model model) {
        bidListService.update(bidList);
        log.info("bidList updated: " + id);
        model.addAttribute("bidList", bidListService.findAll());
        log.trace("Redirect to bidList/list view");
        return "redirect:/bidList/list";
    }

    @GetMapping("/bidList/delete/{id}")
    public String deleteBid(@PathVariable("id") Integer id, Model model) {
        bidListService.delete(bidListService.getById(id));
        log.info("bidList deleted: " + id);
        model.addAttribute("bidList", bidListService.findAll());
        log.trace("Redirect to bidList/list view");
        return "redirect:/bidList/list";
    }
}
