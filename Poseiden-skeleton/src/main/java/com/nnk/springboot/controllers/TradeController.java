package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.services.ITradeService;
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
 * This class is responsible for mapping Trade CRUD
 */
@Log4j2
@Controller
public class TradeController {

    @Autowired
    ITradeService tradeService;

    @RequestMapping("/trade/list")
    public String home(Model model) {
        log.trace("Load trade data" );
        model.addAttribute("trades", tradeService.findAll());
        log.trace("Display trade/list view");
        return "trade/list";
    }

    @GetMapping("/trade/add")
    public String addUser(Trade bid) {
        log.trace("Display trade/add view");
        return "trade/add";
    }

    @PostMapping("/trade/validate")
    public String validate(@Valid Trade trade, BindingResult result, Model model) {
        if (result.hasErrors()) {
            log.error("Invalid trade");
            return "/trade/add";
        } else {
            log.info("New trade added: "+trade.getTradeId());
            tradeService.add(trade);
            model.addAttribute("trades", tradeService.findAll());
            log.trace("Redirect to trade/list view");
            return "redirect:/trade/list";
        }
    }

    @GetMapping("/trade/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("tradeToUpdate", tradeService.getById(id));
        log.info("Trade to update selected by id: " +id);
        log.trace("Display trade/update view");
        return "trade/update";
    }

    @PostMapping("/trade/update/{id}")
    public String updateTrade(@PathVariable("id") Integer id, @Valid Trade trade,
                              BindingResult result, Model model) {
        tradeService.update(trade);
        log.info("trade updated: " +id);
        model.addAttribute("trades", tradeService.findAll());
        log.trace("Redirect to trade/list view");
        return "redirect:/trade/list";
    }

    @GetMapping("/trade/delete/{id}")
    public String deleteTrade(@PathVariable("id") Integer id, Model model) {
        log.info("trade deleted: "+id);
        tradeService.delete(tradeService.getById(id));
        model.addAttribute("trades", tradeService.findAll());
        log.trace("Redirect to trade/list view");
        return "redirect:/trade/list";
    }
}
